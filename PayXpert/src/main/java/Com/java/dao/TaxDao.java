package Com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.java.Exception.TaxCalculationException;
import Com.java.Util.DBConnUtil;
import Com.java.model.Tax;

public class TaxDao 
{
	private Connection con;
	PreparedStatement stat;
	
	public TaxDao()
	{
		con=DBConnUtil.getConnect();
	}
	
	 public List<Tax> getTaxById(int taxId) 
	 {
		 List<Tax> taxes = new ArrayList<Tax>();
		 try 
		 {
			stat=con.prepareStatement("select * from Tax where taxId=?");
			stat.setInt(1, taxId);
			ResultSet r=stat.executeQuery();
			if(r.next())
			{
				taxes.add(new Tax(r.getInt("TaxID"), r.getInt("EmployeeID"), r.getInt("TaxYear"), r.getInt("TaxableIncome"), r.getInt("TaxAmount")));
			}
		} 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
		 
		return taxes;
		 
	 }
	 
	 public List<Tax> getTaxByEmployeeAndYear(int employeeId, int taxYear) throws TaxCalculationException {
		 List<Tax> taxes = new ArrayList<Tax>();
		try 
		{
			stat=con.prepareStatement("select * from Tax where employeeId=? AND taxYear=?");
			stat.setInt(1, employeeId);
			stat.setInt(2, taxYear);
			ResultSet r=stat.executeQuery();
			
			if(r.next())
			{
				taxes.add(new Tax(r.getInt("TaxID"), r.getInt("EmployeeID"), r.getInt("TaxYear"), r.getInt("TaxableIncome"), r.getInt("TaxAmount")));
			}
		} 
		catch (Exception e) 
		{
			throw new TaxCalculationException(e.getMessage());
		}
		
		 return taxes;
		 
	 }
	 
	 public List<Tax> getTaxesForEmployee(int employeeId) {
	        List<Tax> taxes = new ArrayList<Tax>();
	        try {
	        stat=con.prepareStatement("select * from tax where employeeId=? ORDER BY taxYear");
	        stat.setInt(1, employeeId);
	        ResultSet r=stat.executeQuery();
	        
	        while(r.next())
	        {
	        	taxes.add(new Tax(r.getInt("TaxID"), r.getInt("EmployeeID"), r.getInt("TaxYear"), r.getInt("TaxableIncome"), r.getInt("TaxAmount")));
	        }
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        return taxes;
        }
	 
	 public List<Tax> getTaxesForYear(int taxYear) {
	        List<Tax> taxes = new ArrayList<Tax>();
	        try {
		        stat=con.prepareStatement("select * from tax where taxYear=? GROUP BY employeeId");
		        stat.setInt(1, taxYear);
		        ResultSet r=stat.executeQuery();
		        
		        while(r.next())
		        {
		        	taxes.add(new Tax(r.getInt("TaxID"), r.getInt("EmployeeID"), r.getInt("TaxYear"), r.getInt("TaxableIncome"), r.getInt("TaxAmount")));
		        }
		        }
		        catch(Exception e)
		        {
		        	System.out.println(e.getMessage());
		        }
	        return taxes;
	 }
}
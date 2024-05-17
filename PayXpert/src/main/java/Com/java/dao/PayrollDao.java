package Com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.java.Exception.InvalidInputException;
import Com.java.Exception.PayRollGenerationException;
import Com.java.Util.DBConnUtil;
import Com.java.model.Payroll;


public class PayrollDao {
	private Connection con;
	PreparedStatement stat;
	
	public PayrollDao()
	{
		con=DBConnUtil.getConnect();
	}
	
	 public void insertPayrolldata(Payroll payroll) throws InvalidInputException
	 {
	       
	            try {
					stat=con.prepareStatement("INSERT INTO Payroll (payrollId,EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deduction, NetSalary) VALUES (?,?, ?, ?, ?, ?, ?, ?)");
					    
					    stat.setInt(1, payroll.getPayrollID());
					    stat.setInt(2, payroll.getEmployeeID());
			            stat.setDate(3, payroll.getPayPeriodStartDate());
			            stat.setDate(4, payroll.getPayPeriodEndDate());
			            stat.setDouble(5, payroll.getBasicSalary());
			            stat.setDouble(6, payroll.getOvertimePay());
			            stat.setDouble(7, payroll.getDeductions());
			            stat.setDouble(8, payroll.getNetSalary());
			            stat.executeUpdate();
				} 
	            catch (SQLException e) {
					
					throw new InvalidInputException(e.getMessage());
				}
	           
	        
	    }
	 
	 public Payroll getPayrollById(int payrollID) {
		
		 try 
		 {
           stat=con.prepareStatement( "SELECT p.PayrollID, p.EmployeeID, p.PayPeriodStartDate, p.PayPeriodEndDate, p.BasicSalary, p.OvertimePay, p.Deduction, p.NetSalary, " +"e.FirstName, e.LastName, e.Position " +"FROM Payroll p " +"JOIN Employee e ON p.EmployeeID = e.EmployeeID " +"WHERE p.PayrollID = ?");
	       stat.setInt(1, payrollID);
	       ResultSet r = stat.executeQuery();
	            if (r.next()) {
	                return new Payroll(
	                        r.getInt("PayrollID"),
	                        r.getInt("EmployeeID"),
	                        r.getDate("PayPeriodStartDate"),
	                        r.getDate("PayPeriodEndDate"),
	                        r.getDouble("BasicSalary"),
	                        r.getDouble("OvertimePay"),
	                        r.getDouble("Deduction"),
	                        r.getDouble("NetSalary")
	                );
	            }
	        }
		 catch (Exception e)
		 {
	            throw new PayRollGenerationException(e.getMessage());
	        }
	        return null;
	    }
	 
	  public List<Payroll> getPayrollsForPeriod(java.util.Date startDate, java.util.Date endDate)
	  {
		  List<Payroll> p_list=new ArrayList<Payroll>();
		  try
		  {
			  stat=con.prepareStatement("SELECT * FROM Payroll WHERE PayPeriodStartDate >= ? AND PayPeriodEndDate <= ?");
			  stat.setDate(1, (Date) startDate);
	          stat.setDate(2, (Date) endDate);
	          ResultSet r=stat.executeQuery();
	          while(r.next())
	          {
	        	  p_list.add(new Payroll(
	        			    r.getInt("PayrollID"),
	                        r.getInt("EmployeeID"),
	                        r.getDate("PayPeriodStartDate"),
	                        r.getDate("PayPeriodEndDate"),
	                        r.getDouble("BasicSalary"),
	                        r.getDouble("OvertimePay"),
	                        r.getDouble("Deductions"),
	                        r.getDouble("NetSalary")));
	                    
	          }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		  
		return p_list;
		  
	  }

	
}
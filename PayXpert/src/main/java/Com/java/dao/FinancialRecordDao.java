package Com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.FinancialRecordException;
import Com.java.Util.DBConnUtil;
import Com.java.model.FinancialRecord;

public class FinancialRecordDao {
	private Connection con;
	PreparedStatement stat;
	
	public FinancialRecordDao()
	{
		con=DBConnUtil.getConnect();
	}

	public void addFinancialRecord(int recordId,int employeeId, String description, int amount, String recordType) throws FinancialRecordException 
	{
		try 
		{
			stat=con.prepareStatement("insert into FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType) values (?,?,?,?,?,?)");
			stat.setInt(1, recordId);
			stat.setInt(2, employeeId);
			stat.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			stat.setString(4,description);
			stat.setInt(5, amount);
			stat.setString(6, recordType);
			stat.executeUpdate();
		} 
		catch (SQLException e) 
		{
			throw new FinancialRecordException(e.getMessage());
		}
		
	}

	public FinancialRecord getFinancialRecordByID(int recordID) throws FinancialRecordException {
		
		try
		{
			stat=con.prepareStatement("select * from financialRecord where recordId=?");
			stat.setInt(1, recordID);
			ResultSet r=stat.executeQuery();
			if(r.next())
			{
				System.out.println(r.getInt(1)+"  "+r.getInt(2)+"  "+r.getDate(3)+"  "+r.getString(4)+"  "+r.getInt(5)+"  "+r.getString(6));
				
			}
			else
			{
				throw new FinancialRecordException("Invalid");
			}
		}
		catch(SQLException e)
		{
			throw new FinancialRecordException(e.getMessage());
		}
		return null;
		
		
	}
	
	
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeID) throws EmployeeNotFoundException
	{
		try
		{
			stat=con.prepareStatement("select * from financialRecord where employeeId=?");
			stat.setInt(1, employeeID);
			ResultSet r=stat.executeQuery();
			 List<FinancialRecord> al = new ArrayList<FinancialRecord>();
             while (r.next()) 
             {
                al.add(new FinancialRecord(
                     r.getInt("RecordID"),
                     r.getInt("EmployeeID"),
                     r.getDate("RecordDate"),
                     r.getString("Description"),
                     r.getInt("Amount"),
                     r.getString("RecordType")
                 ));
		}
             return al;
		}
		catch(SQLException e)
		{
			throw new EmployeeNotFoundException(e.getMessage());
		}
		
	}
	
	 public List<FinancialRecord> getFinancialRecordsForDate(Date recordDate) throws FinancialRecordException, SQLException{
		 stat=con.prepareStatement("select * from financialRecord where recordDate=?");
			stat.setDate(1, recordDate);
			ResultSet r=stat.executeQuery();
			List<FinancialRecord> alist = new ArrayList<FinancialRecord>();
	                while (r.next()) {
	                    alist.add(new FinancialRecord(
	                        r.getInt("RecordID"),
	                        r.getInt("EmployeeID"),
	                        r.getDate("RecordDate"),
	                        r.getString("Description"),
	                        r.getInt("Amount"),
	                        r.getString("RecordType")
	                    ));
	                }
	                return alist;
	            }
	        }


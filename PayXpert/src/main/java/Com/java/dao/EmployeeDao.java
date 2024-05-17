package Com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.InvalidInputException;
import Com.java.Service.IEmployeeService;
import Com.java.Util.DBConnUtil;
import Com.java.model.Employee;

public class EmployeeDao implements IEmployeeService{

	private Connection con;
	PreparedStatement stat;
	
	public EmployeeDao()
	{
		con=DBConnUtil.getConnect();
	}

	
	public void addEmployee(Employee data) throws InvalidInputException{
		
		try
		{
			stat=con.prepareStatement("insert into Employee (EmployeeID,Firstname,lastName,dateofbirth,gender,email,phoneNumber,address,position,joiningdate,terminationdate) values (?,?,?,?,?,?,?,?,?,?,?)");
			
			stat.setInt(1, data.getEmployeeID());
			stat.setString(2, data.getFirstName());
			stat.setString(3, data.getLastName());
			stat.setDate(4, data.getDateOfBirth());
			stat.setString(5, data.getGender());
			stat.setString(6, data.getEmail());
            stat.setString(7, data.getPhoneNumber());
            stat.setString(8, data.getAddress());
            stat.setString(9, data.getPosition());
			stat.setDate(10, data.getJoiningDate());
			stat.setDate(11, data.getTerminationDate());
			stat.executeUpdate();
		}
		catch(Exception e)
		{
			
			throw new InvalidInputException(e.getMessage());
		}
	}

	public void updateEmployee(String gender,int employeeId) throws EmployeeNotFoundException{
		try
		{
		stat=con.prepareStatement("update Employee set gender=? where employeeId=?");
		stat.setString(1, gender);
		stat.setInt(2,employeeId);
		stat.executeUpdate();
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException(e.getMessage());
			
		}
		
	}
	
	public void removeEmployee(int employeeID) throws EmployeeNotFoundException 
	{
		try
		{
		stat=con.prepareStatement("delete from Employee where employeeId=?");
		stat.setInt(1, employeeID);
		stat.executeUpdate();
		}
		catch(Exception e)
		{
			throw new EmployeeNotFoundException(e.getMessage());
		}
		
	}
	
	public void getAllEmployees() throws EmployeeNotFoundException
	{
		try
		{
			stat=con.prepareStatement("select * from Employee");
			ResultSet r=stat.executeQuery();
			while(r.next())
			{
				System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5)+" "+r.getString(6)+" "+r.getString(7)+" "+r.getString(8));
			}
			
			}
			catch(Exception e)
			{
				throw new EmployeeNotFoundException(e.getMessage());
			}
	}
	public void getEmployeeById(int employeeID) throws EmployeeNotFoundException
	{
		try {
			stat=con.prepareStatement("select firstName,lastName from Employee where employeeID=?");
			stat.setInt(1, employeeID);
			//System.out.println()
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			throw new EmployeeNotFoundException(e.getMessage());
		}
		
	}

	}
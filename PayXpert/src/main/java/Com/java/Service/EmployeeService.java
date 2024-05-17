package Com.java.Service;

import java.sql.Date;
import java.util.Scanner;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.InvalidInputException;
import Com.java.dao.EmployeeDao;
import Com.java.model.Employee;

public class EmployeeService {

	Scanner sc;
	EmployeeDao e_dao;
	
	public EmployeeService()
	{
		sc=new Scanner(System.in);
		e_dao=new EmployeeDao();
	}
	
	
	public void getEmployeeByID()
	{
		Employee data=new Employee();
		System.out.println("Enter Employee ID :");
		data.setEmployeeID(sc.nextInt());
		try 
		{
			e_dao.getEmployeeById(data.getEmployeeID());
		} 
		catch (EmployeeNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public void addEmployee() 
	{
		Employee data=new Employee();
		
		System.out.print("Enter Employee ID: ");
        data.setEmployeeID(sc.nextInt());

        System.out.print("Enter First Name: ");
        sc.nextLine();
        data.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name: ");
       
        data.setLastName(sc.nextLine());

        System.out.print("Enter Date of Birth: ");
        data.setDateOfBirth(Date.valueOf(sc.next()));
        sc.nextLine();
        
        System.out.print("Enter Gender: ");
        
        data.setGender(sc.nextLine());

        System.out.print("Enter Email: ");
        
        data.setEmail(sc.nextLine());

        System.out.print("Enter Phone Number: ");
        
        data.setPhoneNumber(sc.nextLine());

        System.out.print("Enter Address: ");
        
        data.setAddress(sc.nextLine());

        System.out.print("Enter Position: ");
        
        data.setPosition(sc.nextLine());
        
        System.out.print("Enter Joining date: ");
        data.setJoiningDate(Date.valueOf(sc.next()));
        sc.nextLine();
        
        System.out.print("Enter Termination date: ");
        data.setTerminationDate(Date.valueOf(sc.next()));
        
        
        try 
        {
			e_dao.addEmployee(data);
		} 
        catch (InvalidInputException e) 
        {
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee()
	{
		Employee obj=new Employee();
		System.out.print("Enter the ID of employee whose details need to be updated : ");
		obj.setEmployeeID(sc.nextInt());
		System.out.println("Enter Gender :");
		sc.nextLine();
		obj.setGender(sc.nextLine());
		try {
			e_dao.updateEmployee(obj.getGender(), obj.getEmployeeID());
		} catch (EmployeeNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void removeEmployee() 
	{
		Employee obj=new Employee();
		System.out.println("Enter employee ID to remove the employee");
		obj.setEmployeeID(sc.nextInt());
		try 
		{
			e_dao.removeEmployee(obj.getEmployeeID());
		} 
		catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void displayEmployees() throws EmployeeNotFoundException
	{
		e_dao.getAllEmployees();
	}
	
	
}

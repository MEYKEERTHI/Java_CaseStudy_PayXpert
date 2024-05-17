package Com.java.Service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.FinancialRecordException;
import Com.java.dao.FinancialRecordDao;
import Com.java.model.FinancialRecord;


public class FinancialRecordService 
{
	Scanner sc;
FinancialRecordDao f_dao;

public FinancialRecordService()
{
	sc=new Scanner(System.in);
	f_dao=new FinancialRecordDao();
}

public void addFinancialRecord() throws FinancialRecordException {
	 
	System.out.print("Enter Record ID: ");
	int RecordID = sc.nextInt();
	
	System.out.print("Enter Employee ID: ");
	int employeeID = sc.nextInt();
	sc.nextLine();

	System.out.print("Enter Description: ");
	String description = sc.nextLine();

	System.out.print("Enter Amount: ");
	int amount = sc.nextInt();
	sc.nextLine(); 

	System.out.print("Enter Record Type: ");
	String recordType = sc.nextLine();

	f_dao.addFinancialRecord(RecordID, employeeID, description, amount, recordType);
	System.out.println("Financial record added successfully.");
	 } 

 public void getFinancialRecordById() throws  FinancialRecordException
 {
            System.out.print("Enter Record ID: ");
            int recordId = sc.nextInt();
            f_dao.getFinancialRecordByID(recordId);
 }
 public void getFinancialRecordsForEmployee() throws EmployeeNotFoundException
 {
	 try {
	 System.out.println("Enter Employee ID: ");
	 int employeeId=sc.nextInt();
	 sc.nextLine();
	 
	 List<FinancialRecord> al = f_dao.getFinancialRecordsForEmployee(employeeId);
     if (al.isEmpty()) 
     {
         System.out.println("Given employee ID not found : " + employeeId);
     } 
     else 
     {
         for(FinancialRecord data:al)
         {
        	 System.out.println(data);
        	 
         }
     }
	 }
	 catch(Exception e)
	 {
		 throw new EmployeeNotFoundException(e.getMessage());
	 }
 }
 
 public void getFinancialRecordsForDate() {
        try {
            System.out.print("Enter Record Date (yyyy-MM-dd): ");
            String dateStr = sc.nextLine();
            Date recordDate = java.sql.Date.valueOf(dateStr);

            List<FinancialRecord> alist = f_dao.getFinancialRecordsForDate(recordDate);
            if (alist.isEmpty()) {
                System.out.println("No records found for date: " + recordDate);
            } else {
                for (FinancialRecord data : alist) 
                {
                   System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
 }
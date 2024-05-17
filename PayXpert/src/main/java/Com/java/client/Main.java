package Com.java.client;

import java.util.List;
import java.util.Scanner;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.FinancialRecordException;
import Com.java.Exception.TaxCalculationException;
import Com.java.Service.EmployeeService;
import Com.java.Service.FinancialRecordService;
import Com.java.Service.PayrollService;
import Com.java.Service.TaxService;
import Com.java.model.Payroll;
import Com.java.model.Tax;

public class Main {
	
	
	
	public static void main(String[] args) throws FinancialRecordException 
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("1 - To access Financial Records");
		System.out.println("2 - To access Employee Records");
		System.out.println("3 - To access Tax Records");
		System.out.println("4 - To access Payroll Records");
		System.out.println("Enter your choice");
		int c=sc.nextInt();
		
		
		if(c==1)
		{
			FinancialRecordService r=new FinancialRecordService();
			while(true)
			{
				System.out.println("1. Add Financial Record");
				System.out.println("2. Display records using ID");
				System.out.println("3. Display records using Employee");
				System.out.println("4. Display records using date");
				System.out.println("5. Exit");
				System.out.println("Enter your choice");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					r.addFinancialRecord();
					break;
				case 2:
					r.getFinancialRecordById();
					break;
				case 3:
					try {
						r.getFinancialRecordsForEmployee();
					} catch (EmployeeNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					r.getFinancialRecordsForDate();
					break;
				case 5:
					sc.close();
					break;
					default:
						System.out.println("Invalid choice!, please try again");
				}
					
			}
			
		}
		else if(c==2)
		{
			EmployeeService e=new EmployeeService();
			
			while(true)
			{
				System.out.println("1. Add new Employee");
				System.out.println("2. Update employee");
				System.out.println("3. Remove employee");
				System.out.println("4. Display all employees");
				System.out.println("5. Exit");
				
				System.out.println("Enter your choice :");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					e.addEmployee();
					break;
				
				case 2:
					e.updateEmployee();
					break;
				case 3:
					e.removeEmployee();
					break;
				case 4:
					try {
						e.displayEmployees();
					} catch (EmployeeNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 5:
					sc.close();
					break;
				default:
					System.out.println("Invalid choice!, please try again");
			}
		}
		}
		
		
		else if(c==3)
		{
			TaxService t=new TaxService();
		
			 while (true) {
		            
		            System.out.println("1. Get Tax By ID");
		            System.out.println("2. Get Taxes For Employee");
		            System.out.println("3. Get Taxes For Year");
		            System.out.println("4. Exit");

		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();

		            switch (choice) {
		                
		                case 1:
		                    System.out.print("Enter Tax ID: ");
		                    int taxId = sc.nextInt();
		                    List<Tax> tax = t.getTaxById(taxId);
		                    if (tax != null) {
		                        System.out.println("Tax Details: " + tax);
		                    } else {
		                        System.out.println("Tax not found.");
		                    }
		                    break;
		                case 2:
		                    System.out.print("Enter Employee ID: ");
		                    int empId = sc.nextInt();
		                    List<Tax> taxesForEmployee = t.getTaxesForEmployee(empId);
		                    for (Tax taxes : taxesForEmployee) {
		                        System.out.println(taxes);
		                    }
		                    break;
		                case 3:
		                    System.out.print("Enter Tax Year: ");
		                    int year = sc.nextInt();
		                    List<Tax> taxesForYear = t.getTaxesForYear(year);
		                    for (Tax taxes : taxesForYear) {
		                        System.out.println(taxes);
		                    }
		                    break;
		                case 4:
		                    System.out.println("Exiting...");
		                    sc.close();
		                    return;
		                default:
		                    System.out.println("Invalid choice! Please try again.");
		            }
		}
		}
		
		
		else if(c==4)
		{
			PayrollService p=new PayrollService();
		
			while (true) 
			{
	            System.out.println("1. Generate Payroll");
	            System.out.println("2. Get Payroll By ID");
	            System.out.println("3. Insert payroll");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    p.generatePayroll();
	                    break;
	                case 2:
	                    System.out.print("Enter Payroll ID: ");
	                    int payrollID = sc.nextInt();
	                    Payroll payroll = p.getPayrollID(payrollID);
	                    if (payroll != null) {
	                        System.out.println(payroll);
	                    } else {
	                        System.out.println("Payroll not found.");
	                    }
	                    break;
	                  
//	                case 3:
//	                    System.out.print("Enter Employee ID: ");
//	                    int employeeID = scanner.nextInt();
//	                    List<Payroll> payrollsForEmployee = payrollService.getPayrollsForEmployee(employeeID);
//	                    if (!payrollsForEmployee.isEmpty()) {
//	                        for (Payroll p : payrollsForEmployee) {
//	                            System.out.println(p);
//	                        }
//	                    } else {
//	                        System.out.println("No payrolls found for this employee.");
//	                    }
//	                    break;
//	                case 4:
//	                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
//	                    Date startDate = Date.valueOf(scanner.next());
//	                    System.out.print("Enter End Date (YYYY-MM-DD): ");
//	                    Date endDate = Date.valueOf(scanner.next());
//	                    List<Payroll> payrollsForPeriod = payrollService.getPayrollsForPeriod(startDate, endDate);
//	                    if (!payrollsForPeriod.isEmpty()) {
//	                        for (Payroll p : payrollsForPeriod) {
//	                            System.out.println(p);
//	                        }
//	                    } else {
//	                        System.out.println("No payrolls found for this period.");
//	                    }
//	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
			}
		}
		
		
		
		
		}
		

	}

}

package Com.java.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Com.java.model.Payroll;
import Com.java.dao.PayrollDao;

public class PayrollService implements IPayrollService{
		
		Scanner sc;
		PayrollDao pdao;
		
		public PayrollService()
		{
			sc=new Scanner(System.in);
			pdao=new PayrollDao();
		}
		
		
		 public void generatePayroll() {
		        try {
		        	 System.out.println("Enter Payroll ID: ");
			        int payrollID = sc.nextInt();
		            System.out.println("Enter Employee ID: ");
		            int employeeID = sc.nextInt();
		            System.out.println("Enter Start Date : ");
		            Date payPeriodStartDate = Date.valueOf(sc.next());
		            System.out.println("Enter End Date: ");
		            Date payPeriodEndDate = Date.valueOf(sc.next());
		            System.out.println("Enter Basic Salary: ");
		            double basicSalary = sc.nextDouble();
		            System.out.println("Enter Overtime Pay: ");
		            double overtimePay = sc.nextDouble();
		            System.out.println("Enter Deductions: ");
		            double deduction = sc.nextDouble();

		            double netSalary = basicSalary + overtimePay - deduction;
		            Payroll payroll = new Payroll(payrollID, employeeID, payPeriodStartDate, payPeriodEndDate, basicSalary, overtimePay, deduction, netSalary);
		            pdao.insertPayrolldata(payroll);
		        } 
		        catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
		    }

		public Payroll getPayrollID(int payrollID) {
			return pdao.getPayrollById(payrollID);
		}
		}
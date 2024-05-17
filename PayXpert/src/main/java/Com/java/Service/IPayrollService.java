package Com.java.Service;

import Com.java.model.Payroll;

public interface IPayrollService {

      void generatePayroll();
	
	 Payroll getPayrollID(int payrollID);
}

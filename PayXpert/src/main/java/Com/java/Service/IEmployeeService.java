package Com.java.Service;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.InvalidInputException;
import Com.java.model.Employee;

public interface IEmployeeService {
	//Employee getEmployeeID(int employeeID);
		//ArrayList<Employee> getAllEmployees();
		void addEmployee(Employee employeeData) throws InvalidInputException;
	    void updateEmployee(String gender,int employeeID)throws EmployeeNotFoundException;
	    void removeEmployee(int employeeID) throws EmployeeNotFoundException;
}

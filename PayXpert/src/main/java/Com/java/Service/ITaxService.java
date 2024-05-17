package Com.java.Service;

import java.util.List;

import Com.java.model.Tax;

public interface ITaxService 
{
	//double calculateTax(int employeeId, int taxYear) throws TaxCalculationException;
    List<Tax> getTaxById(int taxId);
    List<Tax> getTaxesForEmployee(int employeeId);
    List<Tax> getTaxesForYear(int taxYear);
}

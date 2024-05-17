package Com.java.Service;

import java.util.List;
import java.util.Scanner;

import Com.java.dao.TaxDao;
import Com.java.model.Tax;

public class TaxService implements ITaxService
{
	
	Scanner sc;
	TaxDao t_dao;
	
	public TaxService()
	{
		sc=new Scanner(System.in);
		t_dao=new TaxDao();
	}
	

	

	   

	    @Override
	    public List<Tax> getTaxesForEmployee(int employeeId) 
	    {
	        return t_dao.getTaxesForEmployee(employeeId);
	    }

	    @Override
	    public List<Tax> getTaxesForYear(int taxYear) {
	        return t_dao.getTaxesForYear(taxYear);
	    }

		@Override
		public List<Tax> getTaxById(int taxId) {
			return t_dao.getTaxById(taxId);
		}
		 @Override
	    public double calculateTax(int employeeId, int taxYear) throws TaxCalculationException {
	        try {
	            Tax tax = t_dao.getTaxByEmployeeAndYear(employeeId, taxYear);
	            int taxAmount = (int) (tax.getTaxableIncome()*10);
	            tax.setTaxAmount(taxAmount);
	            t_dao.updateTax(tax);
	            return taxAmount;
	        } catch (Exception e) {
	            throw new TaxCalculationException("Error calculating tax for employee ID: " + employeeId + " and tax year: " + taxYear, e);
	        }
	    }
}

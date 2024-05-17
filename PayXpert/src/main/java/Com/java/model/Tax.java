package Com.java.model;

public class Tax 
{
	 private int taxID;
	    private int employeeID;
	    private int taxYear;
	    private int taxableIncome;
	    private int taxAmount;

	    public Tax() {}

	    public Tax(int taxID, int employeeID, int taxYear, int taxableIncome, int taxAmount) {
	        this.taxID = taxID;
	        this.employeeID = employeeID;
	        this.taxYear = taxYear;
	        this.taxableIncome = taxableIncome;
	        this.taxAmount = taxAmount;
	    }

	    // Getters and Setters
	    public int getTaxID() {
	        return taxID;
	    }

	    public void setTaxID(int taxID) {
	        this.taxID = taxID;
	    }

	    public int getEmployeeID() {
	        return employeeID;
	    }

	    public void setEmployeeID(int employeeID) {
	        this.employeeID = employeeID;
	    }

	    public int getTaxYear() {
	        return taxYear;
	    }

	    public void setTaxYear(int taxYear) {
	        this.taxYear = taxYear;
	    }

	    public double getTaxableIncome() {
	        return taxableIncome;
	    }

	    public void setTaxableIncome(int taxableIncome) {
	        this.taxableIncome = taxableIncome;
	    }

	    public double getTaxAmount() {
	        return taxAmount;
	    }

	    public void setTaxAmount(int taxAmount) {
	        this.taxAmount = taxAmount;
	    }
	    
	    @Override
	    public String toString() {
	        return "Tax{" +
	                "taxID=" + taxID +
	                ", employeeID=" + employeeID +
	                ", taxYear=" + taxYear +
	                ", taxableIncome=" + taxableIncome +
	                ", taxAmount=" + taxAmount +
	                '}';
	    }
}

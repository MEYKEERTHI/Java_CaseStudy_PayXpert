package Com.java.model;

import java.sql.Date;

public class FinancialRecord {
	 private int recordID;
	    private int employeeID;
	    private Date recordDate;
	    private String description;
	    private int amount;
	    private String recordType;

	    public FinancialRecord(int recordID, int employeeID, Date recordDate, String description, int amount, String recordType) {
	        this.recordID = recordID;
	        this.employeeID = employeeID;
	        this.recordDate = recordDate;
	        this.description = description;
	        this.amount = amount;
	        this.recordType = recordType;
	    }

	    public int getRecordID() {
	        return recordID;
	    }

	    public int getEmployeeID() {
	        return employeeID;
	    }

	    public Date getRecordDate() {
	        return recordDate;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public String getRecordType() {
	        return recordType;
	    }

	    public void setRecordID(int recordID) {
	        this.recordID = recordID;
	    }

	    public void setEmployeeID(int employeeID) {
	        this.employeeID = employeeID;
	    }

	    public void setRecordDate(Date recordDate) {
	        this.recordDate = recordDate;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setAmount(int amount) {
	        this.amount = amount;
	    }

	    public void setRecordType(String recordType) {
	        this.recordType = recordType;
	    }
	}
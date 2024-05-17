package Com.java.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Com.java.Exception.EmployeeNotFoundException;
import Com.java.Exception.FinancialRecordException;
import Com.java.model.FinancialRecord;

public interface IFinancialRecordService 
{
	void addFinancialRecord(int recordId,int employeeId,String description,int amount,String recodeType) throws FinancialRecordException;
	FinancialRecord getFinancialRecordByID(int recordID) throws FinancialRecordException;
	List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) throws EmployeeNotFoundException;
	ArrayList<FinancialRecord> getFinancialRecordsForDate(Date recordDate);
}

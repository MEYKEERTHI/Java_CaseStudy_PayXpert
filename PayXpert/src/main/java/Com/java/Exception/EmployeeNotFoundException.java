package Com.java.Exception;

public class EmployeeNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String exception_message)
	{
		super(exception_message);
	}
}

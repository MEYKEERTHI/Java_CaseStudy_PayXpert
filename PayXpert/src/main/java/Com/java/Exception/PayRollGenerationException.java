package Com.java.Exception;

public class PayRollGenerationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PayRollGenerationException(String message) {
        super(message);
    }
}
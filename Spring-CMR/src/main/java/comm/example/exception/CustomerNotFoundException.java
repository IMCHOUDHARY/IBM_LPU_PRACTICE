package comm.example.exception;

public class CustomerNotFoundException extends Throwable {
	private static final long serialVersionUID = 3289290139523389288L;
	private String message;

	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerNotFoundException [message=" + message + "]";
	}
}

package cn.c.core.excepion;

/**
 * 
 * @author hz453@126.com
 */
public class PlatformException extends RuntimeException{

	private static final long serialVersionUID = 2611580814752053058L;


	public PlatformException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PlatformException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlatformException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PlatformException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

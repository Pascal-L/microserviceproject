package microserviceproject.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Allow the controller to return a 404 if an account is not found by simply
 * throwing this exception. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 * 
 * @author Paul Chapman
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicateAlgorythmFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateAlgorythmFoundException(String name) {
		super("One or more algorythm with name: " + name);
	}
}

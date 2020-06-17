package sisima.com.WassimWebApi.Exception;

import org.springframework.http.HttpStatus;

import sisima.com.WassimWebApi.Exception.RestError;


	
public class RestException extends RuntimeException {

	private final RestError error;

	
	public RestException(RestError error){
		super(error.getDescription());
		this.error = error;
	}


	public RestError getError() {
		return error;
	}

}



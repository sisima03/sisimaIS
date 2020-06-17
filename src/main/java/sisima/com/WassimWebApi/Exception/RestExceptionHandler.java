package sisima.com.WassimWebApi.Exception;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sisima.com.WassimWebApi.Exception.RestException;
import sisima.com.WassimWebApi.DTO.DefaultResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);  
	
	@ExceptionHandler(RestException.class)
    public ResponseEntity<Object> handlerException(WebRequest request, RestException exception) {
		DefaultResponse output = new DefaultResponse();
		output.setErrorCode(exception.getError().getRefCode());
		output.setErrorDescription(exception.getError().getDescription());
		output.setFailure();
		output.setAtDate(new Date());
		// TODO : log initial error
		LOGGER.error("Error received from REF  : " + exception.getError().getDescription());
		return handleExceptionInternal(exception, output, new HttpHeaders(), exception.getError().getHttpStatus(), request);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException(WebRequest request, Exception exception) {
		DefaultResponse output = new DefaultResponse();
		output.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		String uniqueKey = UUID.randomUUID().toString();
		//output.setErrorDescription("Internal error id " + uniqueKey);
		output.setErrorDescription("Internal error id " + uniqueKey+" : "+ exception.getMessage());
		output.setFailure();
		output.setAtDate(new Date());
		// TODO : log initial error
		LOGGER.error("Error interne received from REF  uuid {} exception {}", uniqueKey, exception);
		return handleExceptionInternal(exception, output, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}	
	
}

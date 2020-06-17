package sisima.com.WassimWebApi.Exception;


import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class RestError implements Serializable{
	
	private HttpStatus httpStatus;
	private String RefCode;
	private String description;
	
	public RestError(HttpStatus httpStatus, String RefCode, String description) {
		super();
		this.httpStatus = httpStatus;
		this.RefCode = RefCode;
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRefCode() {
		return RefCode;
	}
	public void setRefCode(String RefCode) {
		this.RefCode = RefCode;
	}
	
}



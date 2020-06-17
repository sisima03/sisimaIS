package sisima.com.WassimWebApi.Constants;

import java.util.Date;

import org.springframework.http.HttpStatus;

import sisima.com.WassimWebApi.Exception.RestError;

public final class RestErrorConstants { 
	//Commun
	public static final RestError TECHNICAL_ERROR = new RestError(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Technical error");
	public static final RestError NO_RESUL     = new RestError(HttpStatus.NOT_FOUND, "600", "Pas de résultats trouvés.");
	public static final RestError BAD_IDENTIFIANT       = new RestError(HttpStatus.INTERNAL_SERVER_ERROR, "400", "Objet inexistant");
	public static final RestError COMMUN_BAD_CONTRAT_ID = new RestError(HttpStatus.BAD_REQUEST, "007", "Id contrat incorrecte.");
	
	public static final String SUCCESS_CODE = "000";
	public static final String ERROR_CODE   = "500";

}

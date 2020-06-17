package sisima.com.WassimWebApi.DTO;

import sisima.com.WassimWebApi.Constants.RestErrorConstants;

import java.util.Date;

import sisima.com.WassimWebApi.Constants.ProcessingStatusEnum;

public class DefaultResponse {
	
	
		private ProcessingStatusEnum processingStatus;
		
		private Date atDate;

		private String errorCode;
		
		private String errorDescription;

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorDescription() {
			return errorDescription;
		}

		public void setErrorDescription(String errorDescription) {
			this.errorDescription = errorDescription;
		}

		public ProcessingStatusEnum getprocessingStatus() {
			return processingStatus;
		}

		
		public void setSuccess() {
			this.processingStatus = processingStatus.SUCCESS;
			//this.errorCode = RestErrorConstants.SUCCESS_CODE;
		}	
		
		public void setFailure() {
			this.processingStatus = processingStatus.FAILURE;
			//this.errorCode = RestErrorConstants.ERROR_CODE;
		}
		
		public Date getAtDate() {
			return atDate;
		}

		public void setAtDate(Date atDate) {
			this.atDate = atDate;
		}

		@Override
		public String toString() {
			return "ResponseDefaultOutput [errorCode=" + errorCode
					+ ", errorDescription=" + errorDescription +" processingStatus="+processingStatus+ "]";
		}
		
		
		
	}



package com.neurogine.assesment.domain.dto.response;

import lombok.Data;

@Data
public class CommonErrorResponse {
	
	private String message;

    private String errorCode;
    
    private CommonErrorResponse(String message, String erroCode) {
    	  this.message = message;
          this.errorCode = erroCode;
    }
    
    public static CommonErrorResponse of(String message, String errorCode) {
        return new CommonErrorResponse(message, errorCode);
    }

}

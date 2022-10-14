/*******************************************************************************
 * Copyright Axiata Digital Labs, 2021.
 *******************************************************************************/

package com.neurogine.assesment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neurogine.assesment.common.Constant;
import com.neurogine.assesment.domain.dto.response.CommonErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalExceptionHandler
 *
 * @author Chinthana.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	// Handle Exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {     
    	log.error("Caught Exception in GlobalExceptionHandler", ex);
    	CommonErrorResponse commonErrorResponse = CommonErrorResponse.of(Constant.Responsecode.INTERNAL_SERVER_ERROR.getMessage(), Constant.Responsecode.INTERNAL_SERVER_ERROR.getCode());            
        return new ResponseEntity<>(commonErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    // Handle InputValidationException
    @ExceptionHandler(InputValidationException.class)
    protected ResponseEntity<Object> handleResourceNotFound(InputValidationException ex, WebRequest request) {
    	log.error("Caught InputValidationException in GlobalExceptionHandler", ex);
    	CommonErrorResponse customErrorDetails = CommonErrorResponse.of(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }
    
    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
    	log.error("Caught ResourceNotFoundException in GlobalExceptionHandler", ex);
    	CommonErrorResponse customErrorDetails = CommonErrorResponse.of(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }
    
}

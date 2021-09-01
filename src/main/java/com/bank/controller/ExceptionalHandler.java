package com.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.model.EException;
import com.bank.model.EResponse;
import com.bank.model.EResponse.ResStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionalHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleGeneralExceptions(Exception ex, WebRequest request) {
	        log.error("Exception: " + ResStatus.GENERAL_ERROR);
	        
	        EResponse res = new EResponse();
	        
	        res.setStatus(ResStatus.GENERAL_ERROR);
	        res.setErrorCode(ResStatus.GENERAL_ERROR.getCode());
	        res.setErrorDes(ResStatus.GENERAL_ERROR.name());
	        
	        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { EException.class })
	public ResponseEntity<Object> handleEExceptions(EException ex, WebRequest request) {
	        log.error("Exception: " + ex.getStatus());
	        
	        EResponse res = new EResponse();
	        
	        res.setStatus(ex.getStatus());
	        res.setErrorCode(ex.getStatus().getCode());
	        res.setErrorDes(ex.getStatus().name());
	        
	        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

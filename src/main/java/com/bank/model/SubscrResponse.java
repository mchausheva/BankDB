package com.bank.model;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
public class SubscrResponse {
	
    private final String httpStatusCode;
    private final String messageCode;
    private final String message;
    private ResponseStatus status; 
    private final String externalRefNo;
    private final String refNo;  
    private final String statusDesc;
    private final int userAuthRule;
    
    public enum ResponseStatus {
        OK("00"),
        GENERAL_ERROR("96");
        
        private  String code;
        
        private ResponseStatus(String code) {
            this.code = code;
        }
        
        @JsonValue
        public String getCode() {
            return code;
        }
    }
}

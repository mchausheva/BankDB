package com.bank.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ERequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private final String merchantId;
	
	private final String subscrNumber;
	
	private final String transactionId;
	
	@JsonFormat(pattern = "yyyyMMddHHmmss")
	private final Date dt;
	
	private final Integer amount;
}

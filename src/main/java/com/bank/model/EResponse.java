package com.bank.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@JsonIgnoreProperties(ignoreUnknown = true)
public class EResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonFormat()
	@NonNull
	private ResStatus status;
	private final LocalDate validTo;
	private final Integer amount;
	private final Integer fee;
	private final Integer total;
	private final String shortDesc;
	private final String secondId;
	
	@Setter
	private String errorCode;
	@Setter
	private String errorDes;


	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum ResStatus {
		OK("00"),
		NO_PENDING_DUE("62"),
		MERCHANT_REF_NOT_FOUND("14"),
		INVALID_CODE("58"),
		CARD_LOCKED("75"),
		TEMPORARYLY_UNAVL("80"),
		GENERAL_ERROR("96"), 
		INVALID_DEPOSIT_AMOUNT("13"),
		INVALID_FORMAT("805"),
		DUE_IS_BLOCKED("70"),
		REPEATED_MESSAGE("94"),
		OLD_DUE_PENDING("49"),
		PERIOD_UNAVL("50"),
		NO_INFO_FOR_MERCHANT_REF_NO("52");
		
		private String statuss;

		private ResStatus (String statuss) {
			this.statuss = statuss;
		}
		
		@JsonValue
		public String getCode() {
			return statuss;
		}	
	}
}

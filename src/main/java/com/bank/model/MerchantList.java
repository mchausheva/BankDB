package com.bank.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantList {

	private final int merchantCount;
	
	private final List<Merchant> merchantsList;
}

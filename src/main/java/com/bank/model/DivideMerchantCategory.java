package com.bank.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.Data;

@Data
public class DivideMerchantCategory {

	private List<Merchant> merchantList;
	
	public List<Category> asList() {
		LinkedHashMap<Integer, Category> hashMap = new LinkedHashMap<Integer, Category>();
		int categoryListOrder = 0;
		
		for (Merchant merchant : merchantList) {
			if (!hashMap.containsKey(merchant.getCategoryId())) {
				Category category = new Category(merchant.getCategoryId(), 
												 merchant.getCategoryName(), 
												 categoryListOrder,
												 new ArrayList<Merchant>());
				categoryListOrder++;
				hashMap.put(merchant.getCategoryId(), category);
			}
		}
		
		int merchantListOrder = 0;
		for (Merchant merchant : merchantList) {
			Category category = hashMap.get(merchant.getCategoryId());
			merchant.setCategory(category);
			category.addMerchant(merchant);
			merchant.setListOrder(merchantListOrder);
			merchantListOrder++;
		}
		
		return new ArrayList<Category>(hashMap.values());
	}
	
}

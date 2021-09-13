package com.bank.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.Data;

@Data
public class DivideMerchantCategory {

	private Integer merchantCount;
	private List<Merchant> merchantsList;

	public List<Category> asList() {
		LinkedHashMap<Integer, Category> hashMap = new LinkedHashMap<Integer, Category>();
		int categoryOrder = 0;
		for (Merchant merchant : merchantsList) {
			if (!hashMap.containsKey(merchant.getCategoryId())) {
				Category category = new Category(merchant.getCategoryId(), 
												merchant.getCategoryName(),
											    "A", "B", 
												categoryOrder,
												new ArrayList<Merchant>());
				categoryOrder++;
				hashMap.put(merchant.getCategoryId(), category);
			}
		}

		int merchantOrder = 0;
		for (Merchant merchant : merchantsList) {
			Category category = hashMap.get(merchant.getCategoryId());
			merchant.setCategory(category);
			category.addMerchant(merchant);
			merchant.setListOrder(merchantOrder);
			merchantOrder++;
		}

		return new ArrayList<Category>(hashMap.values());
	}
}

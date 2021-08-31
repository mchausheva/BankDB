package com.bank.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@Entity(name = "category")
@Table(name = "up_merchants_category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_id")
	private final Integer categoryId;
	
	@Column(name = "category_name")
	private final String categoryName;
	
//	@Column(name = "category_type")
//	private final String categoryType;
//	
//	@Column(name = "category_desc")
//	private final String categoryDesc;
	
	@Column(name = "list_order")
	private final Integer listOrder;
	
	@Column(name = "category_merchants")
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private final List<Merchant> categoryMerchants;
	
	public void addMerchant(Merchant merchant) {
		categoryMerchants.add(merchant);
	}
}

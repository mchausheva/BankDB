package com.bank.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@Entity(name = "merchant")
@Table(name = "up_merchants")
@JsonPropertyOrder({ "fullName", "merchantId", "categoryName", "merchantShortDesc", "categoryId"  })
public class Merchant {

	@Id
	@Column(name = "merchant_id")
	private String merchantId;
	
	@Column(name = "category_id", insertable = false, updatable = false)
	private int categoryId;
	
	@Column(name = "merhchant_name")
	private String fullName;
	
	@Column(name = "merchant_desc")
	private String merchantShortDesc;
	
	@JsonIgnore
	@Column(name = "list_order")
	private int listOrder;
	
	@JsonProperty("categoryName")
//	@Column(name = "category_name")
//	private String categoryName;
	public String getCategoryName()
	{
		return category.getCategoryName();
	}
	
	@JsonProperty("categoryName")
	public void setCategoryName(String categoryName)
	{
		if(category == null)
		{
			category = new Category();
		}
		category.setCategoryName(categoryName);
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}

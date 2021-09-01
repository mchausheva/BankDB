package com.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "category")
@Table(name = "up_merchant_categories")
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "merchantList", "categoryId", "categoryType", "categoryName" })
public class Category {

	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_type")
	private String categoryType;

	@JsonIgnore
	@Column(name = "category_desc")
	private String categoryDesc;

	@JsonIgnore
	@Column(name = "list_order")
	private int listOrder;

	@JsonProperty("categoryMerchants")
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Merchant> merchantList;

	public void addMerchant(Merchant m) {
		merchantList.add(m);
	}
}

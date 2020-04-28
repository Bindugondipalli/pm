package com.cts.pm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity(name="products")
@ApiModel(description="This is the product model")
public class Product {
	@ApiModelProperty(value = "A unique key for each product")
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int productId;
	@ApiModelProperty(value = "Name of the productr")
	@Column(name="name")
	private String productName;
	
	@Column(name="description")
	private String productDescription;
	
	@Column
	private float price;
	
	@ManyToOne
	private Vendor vendor;
	

	public Product() {
		super();
	}

	public Product(int productId, String productName, String productDescription, float price, Vendor vendor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.vendor = vendor;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + ", vendor=" + vendor + "]";
	}
	
	
}

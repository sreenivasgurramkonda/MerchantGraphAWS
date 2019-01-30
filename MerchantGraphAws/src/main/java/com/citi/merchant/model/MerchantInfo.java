package com.citi.merchant.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "MerchantNew")
public class MerchantInfo {

	@DynamoDBHashKey(attributeName = "MerchantId")
	private String merchantId;
	
	@DynamoDBRangeKey(attributeName = "MerchantName")
	private String merchantName;
	
	@DynamoDBAttribute(attributeName = "City")
	private String city;
	
	@DynamoDBAttribute(attributeName = "Zip")
	private String zip;
	
	@DynamoDBAttribute(attributeName = "State")
	private String state;
	
	@DynamoDBAttribute(attributeName = "Country")
	private String country;
	
	
	public String getMerchantId() {
		return merchantId;
	}

	
	public String getMerchantName() {
		return merchantName;
	}

	
	public String getCity() {
		return city;
	}

	
	public String getZip() {
		return zip;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	
	

	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "MerchantInfo [merchantId=" + merchantId + ", merchantName=" + merchantName + ", city=" + city + ", zip="
				+ zip + ", state=" + state + ", country=" + country + "]";
	}

}

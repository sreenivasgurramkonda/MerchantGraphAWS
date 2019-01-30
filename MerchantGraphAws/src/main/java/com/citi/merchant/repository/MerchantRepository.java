package com.citi.merchant.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.citi.merchant.model.MerchantInfo;

@Repository
public class MerchantRepository {
	
	@Autowired
	AmazonDynamoDB dynamoDB;
	
	private static final Logger log = LoggerFactory.getLogger(MerchantRepository.class);
	

	public List<MerchantInfo> findById(String merchantId){
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue(merchantId));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("MerchantId =:val1").withExpressionAttributeValues(eav);
		List<MerchantInfo> queryResult = mapper.scan(MerchantInfo.class, scanExpression);
		return queryResult;
	}
	
	public List<MerchantInfo> find(String merchantId, String merchantName) {
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue(merchantId));
        eav.put(":val2", new AttributeValue(merchantName));
        DynamoDBQueryExpression<MerchantInfo> queryExpression = new DynamoDBQueryExpression<MerchantInfo>()
            .withKeyConditionExpression("MerchantId = :val1 and begins_with(MerchantName, :val2)").withExpressionAttributeValues(eav);
        List<MerchantInfo> queryResult = mapper.query(MerchantInfo.class, queryExpression);
		return queryResult;
	}
	
	public List<MerchantInfo> findByName(String merchantName){
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue(merchantName));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("begins_with(MerchantName, :val1)").withExpressionAttributeValues(eav);
		List<MerchantInfo> queryResult = mapper.scan(MerchantInfo.class, scanExpression);
		return queryResult;
	}
	
	  
}

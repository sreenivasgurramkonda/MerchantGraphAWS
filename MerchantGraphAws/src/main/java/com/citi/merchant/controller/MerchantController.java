package com.citi.merchant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.merchant.model.MerchantInfo;
import com.citi.merchant.repository.MerchantRepository;

@RestController
public class MerchantController {
	
	@Autowired
	MerchantRepository merchantInfoRepository;
	
		
	@RequestMapping(value = "/merchant", method=RequestMethod.GET)
	public  ResponseEntity<List<MerchantInfo>> getCustomerById(@RequestParam(required = false)String id, @RequestParam(required = false)String name){
		ResponseEntity<List<MerchantInfo>> responseEntity = null;
		List<MerchantInfo> result = new ArrayList<>();
		if(id != null && name != null) {
			List<MerchantInfo> merchants = merchantInfoRepository.find(id, name);
			result = merchants;
		} else if(id !=null) {
			List<MerchantInfo> merchants =  merchantInfoRepository.findById(id);
			result = merchants;
		}else if(name !=null) {
			List<MerchantInfo> merchants = merchantInfoRepository.findByName(name);
			result = merchants;
		}
		responseEntity = ResponseEntity.status(HttpStatus.OK).body(result);
		return responseEntity;
	}
	
	
	
}

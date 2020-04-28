package com.codervj.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codervj.beans.BaseResponse;
import com.codervj.beans.PaymentRequest;
import com.codervj.constants.ReqResCodes;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private final String sharedKey = "SAMPLEKEY123";
	
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
		
		System.out.println("In Payment controller");
		
		BaseResponse baseResponse = new BaseResponse();
		if(sharedKey.equalsIgnoreCase(key)) {
			int userId = request.getUserId();
			String itemId = request.getItemId();
			Double price = request.getPrice();
			
			/*
			 * Process the request and Return response to client
			 */
			System.out.println("key matches");
			
			baseResponse.setCode(ReqResCodes.CODE_SUCCESS);
			baseResponse.setStatus(ReqResCodes.SUCCESS_STATUS); 
		
		}else {
			System.out.println("key does not match");

			
			baseResponse.setCode(ReqResCodes.CODE_FAILURE);
			baseResponse.setStatus(ReqResCodes.ERROR_STATUS); 
		}
		
		return baseResponse;
		
	}
	
}

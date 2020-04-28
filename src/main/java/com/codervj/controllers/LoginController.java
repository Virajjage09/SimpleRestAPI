package com.codervj.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codervj.beans.BaseResponse;
import com.codervj.beans.LoginRequest;
import com.codervj.constants.ReqResCodes;

@RestController
@RequestMapping("/userLogin")
public class LoginController {
	
	private final String username = "abc";
	private final String password = "123";
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResponse login(@RequestBody LoginRequest loginRequest) {
		
		System.out.println("***********In Login Controller*******");
		
		System.out.println("***Login Request : "+loginRequest.toString()); 
		
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(ReqResCodes.CODE_FAILURE);
		baseResponse.setStatus(ReqResCodes.ERROR_STATUS); 
		
		if(loginRequest.getUsername() != null && !loginRequest.getUsername().isEmpty()) {
			if(loginRequest.getPassword()!= null && !loginRequest.getPassword().isEmpty()) {
				
				if(loginRequest.getUsername().equalsIgnoreCase(username)) {
					if(loginRequest.getPassword().equalsIgnoreCase(password)) {
					
						System.out.println("***********Login success*******");

						
						baseResponse.setCode(ReqResCodes.CODE_SUCCESS);
						baseResponse.setStatus(ReqResCodes.SUCCESS_STATUS); 
						baseResponse.setMessage("Login Successfull."); 
						return baseResponse;
					
					}else {
						System.out.println("***********Login failed*******");
						baseResponse.setMessage("Login Failed."); 
						return baseResponse;
					}
				}else {
					baseResponse.setMessage("User does not exist"); 
					return baseResponse;
				}
				
			}else {
				baseResponse.setMessage("Password is empty."); 
				return baseResponse;
			}
		}else {
			baseResponse.setMessage("Username is empty."); 
			return baseResponse;
		}
		
	}

}

package com.ibm.motoInsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.motoInsure.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendMail/{email}")
	public String sendEmail(@PathVariable (value="email", required=true) String email) {
		return emailService.sendEmail(email);
		
	}
}

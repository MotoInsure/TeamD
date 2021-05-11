package com.ibm.motoInsure.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.ibm.motoInsure.bean.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService {

	    
	    private final String ACCOUNT_SID =System.getenv("TWILIO_ACCOUNT_SID");

	    private final String AUTH_TOKEN =System.getenv("TWILIO_AUTH_TOKEN");

	    private final String FROM_NUMBER ="+15614755770";

	    public void send(SMS sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());
	        // Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}


package com.ibm.motoInsure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.ibm.motoInsure.bean.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService {

	    
	    private final String ACCOUNT_SID ="ACf068324c63778525aa9bcefe35bf35f4";

	    private final String AUTH_TOKEN = "f786598821cc678c28d43b4e34e16362";

	    private final String FROM_NUMBER = "+15614755770";

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


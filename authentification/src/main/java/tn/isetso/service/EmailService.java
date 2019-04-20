package tn.isetso.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.isetso.entities.Users;
@Service
@Transactional

public class EmailService {
	
	  @Autowired
	    public JavaMailSender emailSender;
	 
	
public String sendAccountInformation(Users u , String password) {

SimpleMailMessage message = new SimpleMailMessage();
message.setTo(u.getEmail());
message.setSubject("Account Information");
message.setText("hello , email: "+u.getEmail() + " password : " + password);
emailSender.send(message);
return "Email Sent!";

}
}

package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.isetso.dao.UserRepository;
import tn.isetso.entities.Users;
import tn.isetso.service.AccountService;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;
	  @Autowired
	  public JavaMailSender emailSender;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public Users signUp(@RequestBody RegistrationForm data) {
		String email=data.getEmail();
		Users user = accountService.findUserByEmail(email);
		
		if (user!=null) throw new RuntimeException("This user already exist");
		return  accountService.saveUser(data);
		
		}
	
	
	
	

	
}

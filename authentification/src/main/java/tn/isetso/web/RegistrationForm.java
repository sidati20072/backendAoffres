package tn.isetso.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {

	private String username;
	private String email;
	private String password;
	private String repassword;
	private String typecreation;
	
}

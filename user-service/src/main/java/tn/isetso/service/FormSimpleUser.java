package tn.isetso.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormSimpleUser {

	private String username;
	private String email;
	private String password;
	private String repassword;
	private String typecreation;
	
}
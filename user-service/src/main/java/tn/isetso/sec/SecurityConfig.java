package tn.isetso.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
/*
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth  ) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
		
		
	}*/
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

			.and()
				.authorizeRequests()
				.antMatchers("/entreprise/**")
				.permitAll()
				.antMatchers(HttpMethod.POST,"/users/**").permitAll()
				.antMatchers(HttpMethod.GET,"/users/**").hasAuthority("ADMIN")

				.anyRequest().permitAll()

			.and()
				.addFilterBefore(new JWTAuthorizationFiltre(), UsernamePasswordAuthenticationFilter.class);
				//.formLogin().loginProcessingUrl("/login");
				
		
	}
	
	
	
}

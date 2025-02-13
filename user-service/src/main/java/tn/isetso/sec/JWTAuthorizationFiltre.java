package tn.isetso.sec;

import java.io.IOException;
import java.util.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFiltre extends OncePerRequestFilter{
    private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200");

    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.addHeader("Access-Control-Allow-headers", "token, Origin, Accept, X-Requested-With, Headers,Authorization, authorization,token,amount");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials,Authorization, authorization,token,amount");
	    response.setHeader("Access-Control-Allow-Headers", "token, Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization,Authorization,token,amount");

        // Access-Control-Allow-Origin
        //String origin = request.getHeader("Origin");
        //response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
        response.setHeader("Vary", "Origin,token,amount");

        // Access-Control-Max-Age
        response.setHeader("Access-Control-Max-Age", "3600");
        // Access-Control-Allow-Credentials
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // Access-Control-Allow-Headers
        response.setHeader("Access-Control-Allow-Headers",
                "Origin,token,amount, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");


        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,PATCH,DELETE");
		if (request.getMethod().equals("OPTIONS")){
			
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);
			
			System.out.println("******** secret tokeeen ********* ");
			System.out.println(jwtToken);
			
			if (jwtToken==null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				
				filterChain.doFilter(request, response); 
				
			
				return ;
			}
			
			Claims claims=(Claims) Jwts.parser()
					.setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, ""))
					.getBody();
			String username=claims.getSubject();
			
			ArrayList<Map<String,String>> roles = (ArrayList<Map<String , String>>) claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
					
			UsernamePasswordAuthenticationToken authenticationToken= 
					new UsernamePasswordAuthenticationToken(username, null,authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			filterChain.doFilter(request, response);
		}
		
	}
	
	

}

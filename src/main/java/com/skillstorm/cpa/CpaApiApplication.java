package com.skillstorm.cpa;

import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
public class CpaApiApplication {

	//testing test
	public static void main(String[] args) {
		SpringApplication.run(CpaApiApplication.class, args);

	}
	
	
	 //Here we are disabling CORS protection entirely. I looked into enabling CORS, but to all accounts it would have required a lot of additional work
	//that I do not have time for. As this is not a function critical process, I am bypassing all forms of CORS protection for the moment.
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		http.httpBasic(Customizer.withDefaults());
		
		
		http.csrf().disable();
		

		http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
	           CorsConfiguration cc = new CorsConfiguration().applyPermitDefaultValues();
	           cc.setAllowedMethods(new LinkedList<>(Arrays.asList("GET", "POST", "PUT", "DELETE")));
	           return cc;
			})
	    );
		
		http.authorizeHttpRequests(requests -> {
			

			requests.requestMatchers(HttpMethod.GET, "/**").permitAll();
			requests.anyRequest().permitAll();
			
		});
		
		return http.build();
		
	}

}

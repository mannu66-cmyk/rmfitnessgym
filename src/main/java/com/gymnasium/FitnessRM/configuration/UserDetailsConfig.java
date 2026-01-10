package com.gymnasium.FitnessRM.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		UserDetails user = User.builder().username("admin123@gmail.com").password(encoder.encode("Manoj05@"))
				.roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user);
	}
}

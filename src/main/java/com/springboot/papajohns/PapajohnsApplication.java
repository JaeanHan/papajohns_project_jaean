package com.springboot.papajohns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PapajohnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapajohnsApplication.class, args);
	}

//	@Bean
//	UserDetailsService user() {
//		User user = User.builder()
//				.username("user1")
//				.password(passwordEncoder().encode("1234"))
//				.role("USER")
//				.build();
//
//		User jaean = User.builder()
//				.username("jaean")
//				.password(passwordEncoder().encode("1234"))
//				.role("ADMIN")
//				.build();
//
//		UserDetails user1 = new PrincipalDetails(user);
//		UserDetails admin = new PrincipalDetails(jaean);
//
//		return new InMemoryUserDetailsManager(user1, admin);
//	}
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}

package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeTest {

	@Test
	public void testEncoderPassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "root";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println(encodedPassword);
		
		
		boolean match= passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertThat(match).isTrue();
		
	}
}

package com.fotovacreation.springMVC;

import com.fotovacreation.springMVC.model.UserDto;
import com.fotovacreation.springMVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserDto userDto1 = new UserDto("james", passwordEncoder.encode("1234"), "ADMIN");
		UserDto userDto2 = new UserDto("thomas", passwordEncoder.encode("1234"), "USER");

		userRepository.save(userDto1);
		userRepository.save(userDto2);

	}
}

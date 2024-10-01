package com.fotovacreation.springMVC;

import com.fotovacreation.springMVC.model.CardEntity;
import com.fotovacreation.springMVC.model.ProductEntity;
import com.fotovacreation.springMVC.model.UserEntity;
import com.fotovacreation.springMVC.repository.CardRepository;
import com.fotovacreation.springMVC.repository.ProductRepository;
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
	private CardRepository cardRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserEntity userEntity1 = UserEntity.builder()
				.username("james")
				.password( passwordEncoder.encode("1234"))
				.role("ROLE_ADMIN")
				.build();


		UserEntity userEntity2 = UserEntity.builder()
				.username("thomas")
				.password( passwordEncoder.encode("1234"))
				.role("ROLE_USER")
				.build();

		userRepository.save(userEntity1);
		userRepository.save(userEntity2);

		ProductEntity productEntity1 = ProductEntity.builder()
				.price(2.5F)
				.name("Pomme")
				.build();

		ProductEntity productEntity2 = ProductEntity.builder()
				.price(3.5F)
				.name("Peche")
				.build();

		productRepository.save(productEntity1);
		productRepository.save(productEntity2);

		CardEntity cardEntity = CardEntity.builder()
				.name("Arcbound ravager")
				.photoUrl("arcbound_ravager.png")
				.build();

		cardRepository.save(cardEntity);

	}
}

package com.fuseinterns.libraryManagementSystem;

import com.fuseinterns.libraryManagementSystem.user.User;
import com.fuseinterns.libraryManagementSystem.user.UserRepository;
import com.fuseinterns.libraryManagementSystem.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class LibraryManagementSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Component
	public class DataLoader implements CommandLineRunner {
		@Autowired
		private UserService userService;
		private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

		@Override
		public void run(String... strings) throws Exception {
			User user = new User();
			user.setId("ADM-17-1");
			user.setFirstName("Admin");
			user.setEmail("admin@lms.com");
			user.setRole("admin");
			user.setLastName("Admin");
			user.setPassword("admin");
			userService.addUser(user);
		}
	}
}

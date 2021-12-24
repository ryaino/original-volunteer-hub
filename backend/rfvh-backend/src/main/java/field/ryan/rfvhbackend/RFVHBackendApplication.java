package field.ryan.rfvhbackend;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import field.ryan.rfvhbackend.repositories.User;
import field.ryan.rfvhbackend.repositories.UserRepository;

@SpringBootApplication
public class RFVHBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RFVHBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}

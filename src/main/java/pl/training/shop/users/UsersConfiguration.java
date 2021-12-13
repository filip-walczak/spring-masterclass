package pl.training.shop.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfiguration {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}

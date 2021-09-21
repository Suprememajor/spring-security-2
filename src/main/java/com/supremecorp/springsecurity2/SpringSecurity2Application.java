package com.supremecorp.springsecurity2;

import com.supremecorp.springsecurity2.models.Role;
import com.supremecorp.springsecurity2.models.User;
import com.supremecorp.springsecurity2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurity2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity2Application.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Nobert Sama", "major", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Prince Junior", "strawby", "1234", new ArrayList<>()));

            userService.addRoleToUser("major", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("strawby", "ROLE_USER");
            userService.addRoleToUser("major", "ROLE_ADMIN");
            userService.addRoleToUser("strawby", "ROLE_MANAGER");
            userService.addRoleToUser("major", "ROLE_MANAGER");
        };
    }

}

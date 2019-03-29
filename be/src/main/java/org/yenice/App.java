package org.yenice;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.yenice.todolist.CORSFilter;
import org.yenice.todolist.JwtProvider;
import org.yenice.user.User;
import org.yenice.user.UserRepository;

import javax.servlet.Filter;

@SpringBootApplication
@EnableJpaRepositories
public class App {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public JwtProvider getJwtProvider() {
        return new JwtProvider();
    }

    @Bean
    public InitializingBean initDb() {
        return () -> {
            if (userRepository.findByEmail("default@user.com") == null) {
                User defaultUser = new User();
                defaultUser.setEmail("default@user.com");
                defaultUser.setPassword("123456");
                defaultUser.setAccountNonExpired(true);
                defaultUser.setAccountNonLocked(true);
                defaultUser.setCredentialsNonExpired(true);
                userRepository.save(defaultUser);
            }
        };
    }

    @Bean
    public Filter corsFilter() {
        return new CORSFilter();
    }

}

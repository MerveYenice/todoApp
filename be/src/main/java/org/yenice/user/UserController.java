package org.yenice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yenice.todolist.JwtProvider;

import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping("/user")
public class UserController {

    private static long expirationMillis = 60 * 100 * 10;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> payload) {
        String email = String.valueOf((Object) payload.get("email"));
        String password = String.valueOf((Object) payload.get("password"));
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())
                    && user.isAccountNonExpired()
                    && user.isAccountNonLocked()
                    && user.isCredentialsNonExpired()
                    ) {
                return jwtProvider.getTokenForUser(email, expirationMillis);
            }
        }
        return null;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody Map<String, Object> payload) {
        String email = String.valueOf((Object) payload.get("email"));
        String password = String.valueOf((Object) payload.get("password"));
        String name = String.valueOf((Object) payload.get("password"));
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }

}

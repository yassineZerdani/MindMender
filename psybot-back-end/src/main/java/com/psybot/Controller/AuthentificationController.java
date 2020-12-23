package com.psybot.Controller;

import com.psybot.JSONREQRES.SigninRequest;
import com.psybot.JSONREQRES.SignupRequest;
import com.psybot.Models.User;
import com.psybot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthentificationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/signin")
    public ResponseEntity<?> singinUser(@RequestBody @Validated SigninRequest signinRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getUsername(),signinRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(signinRequest.getUsername());
        return ResponseEntity.ok(user);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody  SignupRequest signupRequest){
        User user = new User(signupRequest.getUsername(),signupRequest.getPassword(),signupRequest.getEmail(),signupRequest.getRole());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signupRequest.getUsername(),signupRequest.getPassword()
                )
        );
        System.out.println("User registred");
        return ResponseEntity.ok(user);
    }
}

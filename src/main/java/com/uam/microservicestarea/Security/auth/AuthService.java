package com.uam.microservicestarea.Security.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.uam.microservicestarea.Security.jwt.JwtService;
import com.uam.microservicestarea.Security.model.User;
import com.uam.microservicestarea.Security.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class AuthService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user;
        user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);
        String token = jwtService.getToken(user);

/*
        return AuthResponse.builder()
                .token(token)
                .build();*/
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        return authResponse;
    }


    public AuthResponse register(RegisterRequest registerRequest) {
        User user = modelMapper.map(registerRequest, User.class);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
        /*
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();*/
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(user));
        return authResponse;
    }

}

package com.bancodebogota.eventmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodebogota.eventmanager.dto.LogedUserDTO;
import com.bancodebogota.eventmanager.dto.UserDTO;
import com.bancodebogota.eventmanager.entity.User;
import com.bancodebogota.eventmanager.repository.UserRepository;
import com.bancodebogota.eventmanager.service.AuthenticationService;
import com.bancodebogota.eventmanager.service.JwtService;


@RequestMapping("/auth")
@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8081"})
public class AuthController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LogedUserDTO> authenticateToLogIn(@RequestBody UserDTO userDto) {
        User authenticatedUser = authenticationService.authenticate(userDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LogedUserDTO loginResponse = new LogedUserDTO();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/path")
    public User getMethodName(@RequestBody UserDTO userDto) {
        return userRepository.findByNick(userDto.getUsername())
        .orElseThrow();
    }
    
}

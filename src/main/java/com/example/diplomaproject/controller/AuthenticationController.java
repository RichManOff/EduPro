package com.example.diplomaproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/auth")
@RequiredArgsConstructor
public class AuthenticationController {

//    private final AuthenticationManager authenticationManager;
//    private final UserDao userDao;
//    private final JwtUtils jwtUtils;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticate(
//            @RequestBody AuthenticationRequest request
//    ){
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//        );
//        final UserDetails user = userDao.findUserByEmail(request.getEmail());
//        if (user != null){
//            return ResponseEntity.ok(jwtUtils.generateToken(user));
//        }
//
//        return ResponseEntity.status(400).body("Some error");
//    }
}

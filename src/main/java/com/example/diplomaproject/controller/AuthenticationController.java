package com.example.diplomaproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthenticationController {
    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index-DESKTOP-QMGODCK");
    }

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloworld() {
        return ResponseEntity.ok("index-DESKTOP-QMGODCK");
    }
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

package com.gym_backend.api;

import com.gym_backend.config.AuthentificationService;
import com.gym_backend.dao.request.SigninRequest;
import com.gym_backend.dao.request.SignupRequest;
import com.gym_backend.dao.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControler {
    private final AuthentificationService authentificationService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SigninRequest request){
        return ResponseEntity.ok(authentificationService.signin(request));
    }
    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authentificationService.signup(request));
    }

}

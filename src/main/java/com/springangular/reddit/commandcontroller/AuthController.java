package com.springangular.reddit.commandcontroller;

import com.springangular.reddit.dto.AuthenticationResponse;
import com.springangular.reddit.dto.LoginRequest;
import com.springangular.reddit.dto.RegisterRequest;
import com.springangular.reddit.services.authentication.LoginService;
import com.springangular.reddit.services.authentication.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

  private final RegistrationService registrationService;
  private final LoginService loginService;

  @PostMapping("/signup")
  public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
    registrationService.signup(registerRequest);

    return new ResponseEntity<>("Registration success!", HttpStatus.OK);
  }

  @GetMapping("/accountactivation/{userToken}")
  public ResponseEntity<String> activateAccount(@PathVariable String userToken) {
    registrationService.activateAccount(userToken);

    return new ResponseEntity<>("Activation success!", HttpStatus.OK);
  }

  @PostMapping("/login")
  public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
    return loginService.login(loginRequest);
  }
}

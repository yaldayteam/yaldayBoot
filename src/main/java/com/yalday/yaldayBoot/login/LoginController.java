package com.yalday.yaldayBoot.login;

import com.yalday.yaldayBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public final class LoginController {

  private UserRepository userRepository;

  @Autowired
  public LoginController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/authenticate")
  public String authenticate (final String username, final String password){
    //TODO authenticate against db
    //TODO return token
    return "authenticated";
  }

}

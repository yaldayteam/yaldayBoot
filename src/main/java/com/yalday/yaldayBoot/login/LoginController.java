package com.yalday.yaldayBoot.login;

import com.yalday.yaldayBoot.entity.Customer;
import com.yalday.yaldayBoot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public final class LoginController {

  private CustomerRepository customerRepository;

  @Autowired
  public LoginController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @PostMapping("/login")
  public String authenticate (@RequestBody final Customer customer){
    //TODO authenticate against db
    //TODO return token
    System.out.println(customer);
    return "authenticated";
  }

}

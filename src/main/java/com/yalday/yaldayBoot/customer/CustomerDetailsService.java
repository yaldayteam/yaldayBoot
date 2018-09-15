package com.yalday.yaldayBoot.customer;

import com.yalday.yaldayBoot.entity.Customer;
import com.yalday.yaldayBoot.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class CustomerDetailsService implements UserDetailsService {

  private final CustomerRepository customerRepository;

  public CustomerDetailsService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    Optional<Customer> customer = customerRepository.findByUsername(username);
    if (!customer.isPresent()) {
      throw new UsernameNotFoundException(username);
    }else {
      return new User(customer.get().getUsername(), customer.get().getPassword(), emptyList());
    }
  }
}

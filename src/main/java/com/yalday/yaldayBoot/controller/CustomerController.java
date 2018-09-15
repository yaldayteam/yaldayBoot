package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.Customer;
import com.yalday.yaldayBoot.exception.ResourceNotFoundException;
import com.yalday.yaldayBoot.exception.UserExistsException;
import com.yalday.yaldayBoot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public final class CustomerController {

  private final CustomerRepository customerRepository;

  @Autowired
  private CustomerController(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  @GetMapping(path="/users", produces="application/json")
  public List<Customer> getAllUsers() {
    return customerRepository.findAll();
  }

  @PostMapping(path="/users")
  public Customer createUser(@Valid @RequestBody Customer customer) {
    Optional<Customer> optionalUser = customerRepository.findByUsername(customer.getUsername());
    optionalUser.ifPresent(returnedMerchant -> {throw new UserExistsException();});
    return customerRepository.save(customer);
  }

  @GetMapping("/users/{name}")
  public Customer getUserByName(@PathVariable(value = "name") String name) {
    return customerRepository.findByUsername(name)
      .orElseThrow(() -> new ResourceNotFoundException("Customer", "name", name));
  }

  @PutMapping("/users")
  public Customer updateUser(@Valid @RequestBody Customer customerDetails) {
    Customer customer = customerRepository.findById(customerDetails.getId())
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", customerDetails.getId()));
    customer.setUsername(customerDetails.getUsername());
    return customerRepository.save(customer);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
    Customer customer = customerRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    customerRepository.delete(customer);
    return ResponseEntity.ok().build();
  }
}

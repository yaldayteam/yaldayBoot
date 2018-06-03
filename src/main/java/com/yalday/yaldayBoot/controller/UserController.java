package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.User;
import com.yalday.yaldayBoot.exception.ResourceNotFoundException;
import com.yalday.yaldayBoot.exception.UserExistsException;
import com.yalday.yaldayBoot.repository.UserRepository;
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
public final class UserController {

  private final UserRepository userRepository;

  @Autowired
  private UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping(path="/users", produces="application/json")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping(path="/users")
  public User createUser(@Valid @RequestBody User user) {
    Optional<User> optionalUser = userRepository.findByName(user.getName());
    optionalUser.ifPresent(returnedMerchant -> {throw new UserExistsException();});
    return userRepository.save(user);
  }

  @GetMapping("/users/{name}")
  public User getUserByName(@PathVariable(value = "name") String name) {
    return userRepository.findByName(name)
      .orElseThrow(() -> new ResourceNotFoundException("User", "name", name));
  }

  @PutMapping("/users")
  public User updateUser(@Valid @RequestBody User userDetails) {
    User user = userRepository.findById(userDetails.getId())
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", userDetails.getId()));
    user.setName(userDetails.getName());
    return userRepository.save(user);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    userRepository.delete(user);
    return ResponseEntity.ok().build();
  }
}

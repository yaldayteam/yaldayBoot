package com.yalday.yaldayBoot.repository;

import com.yalday.yaldayBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

  List<User> findAll();

  User save(User created);

  void deleteByName(String name);

  Optional<User> findByName(String name);

  Optional<User> findById(Long id);
}


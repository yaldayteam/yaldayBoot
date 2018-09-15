package com.yalday.yaldayBoot.repository;

import com.yalday.yaldayBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

  List<Customer> findAll();

  Customer save(Customer created);

  void deleteByUsername(String name);

  Optional<Customer> findByUsername(String name);

  Optional<Customer> findById(Long id);
}


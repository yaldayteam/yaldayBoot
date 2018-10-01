package com.yalday.yaldayBoot.repository;

import com.yalday.yaldayBoot.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@Transactional
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

  List<Merchant> findAll();

  Merchant save(Merchant created);

  void deleteByName(String name);

  Optional<Merchant> findByName(String name);

  Optional<Merchant> findById(Long id);
  
  List<Merchant> findByNameContaining(String name);
 
}

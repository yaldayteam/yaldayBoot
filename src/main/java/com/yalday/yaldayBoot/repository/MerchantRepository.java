package com.yalday.yaldayBoot.repository;

import com.yalday.yaldayBoot.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

  List<Merchant> findAll();

  Merchant save(Merchant created);

  Optional<Merchant> findById(Long merchantId);

  void delete(Long merchantId);


}

package com.yalday.yaldayBoot.repository;

import com.yalday.yaldayBoot.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

  List<Merchant> findAll();

}

package com.yalday.yaldayBoot.service;

import com.yalday.yaldayBoot.entity.Merchant;
import com.yalday.yaldayBoot.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService{

  @Autowired
  private MerchantRepository merchantRepository;

  @Override
  public List<Merchant> loadAll() {
    return merchantRepository.findAll();
  }

}

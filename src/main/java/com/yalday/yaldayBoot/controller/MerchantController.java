package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.Merchant;
import com.yalday.yaldayBoot.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MerchantController {

  final MerchantRepository merchantRepository;

  @Autowired
  public MerchantController(final MerchantRepository merchantRepository) {
    this.merchantRepository = merchantRepository;
  }

  @GetMapping("/test")
  String get(){
    return "Hello from get";
  }

  @GetMapping("/merchants")
  public List<Merchant> getAllMerchants() {
    System.out.println("MerchantController.getAllMerchants");
    return merchantRepository.findAll();
  }
}

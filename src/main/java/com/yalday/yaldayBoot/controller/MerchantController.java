package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.Merchant;
import com.yalday.yaldayBoot.exception.ResourceNotFoundException;
import com.yalday.yaldayBoot.repository.MerchantRepository;
import com.yalday.yaldayBoot.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "api")
public class MerchantController {

  @Autowired
  MerchantService merchantService;

  @RequestMapping("/test")
  String get(){
    return "Hello from get";
  }

  @GetMapping("/merchants")
  public List<Merchant> getAllMerchants() {
    return merchantService.loadAll();
  }
}

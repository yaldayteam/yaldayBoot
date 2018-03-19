package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.Merchant;
import com.yalday.yaldayBoot.exception.ResourceNotFoundException;
import com.yalday.yaldayBoot.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class MerchantController {

  private final MerchantRepository merchantRepository;

  @Autowired
  public MerchantController(final MerchantRepository merchantRepository) {
    this.merchantRepository = merchantRepository;
  }

  @GetMapping(path="/merchants", produces="application/json")
  public List<Merchant> getAllMerchants() {
    return merchantRepository.findAll();
  }

  @PostMapping(path="/merchants")
  public Merchant createMerchant(@Valid @RequestBody Merchant merchant) {
    return merchantRepository.save(merchant);
  }

  @GetMapping("/merchants/{id}")
  public Merchant getMerchantById(@PathVariable(value = "id") Long merchantId) {
    return merchantRepository.findById(merchantId)
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));
  }

  @PutMapping("/merchants/{id}")
  public Merchant updateMerchant(@PathVariable(value = "id") Long merchantId,
                         @Valid @RequestBody Merchant merchantDetails) {

    Merchant merchant = merchantRepository.findById(merchantId)
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));

    merchant.setName(merchantDetails.getName());

    return merchantRepository.save(merchant);
  }

  @DeleteMapping("/merchants/{id}")
  public ResponseEntity<?> deleteMerchant(@PathVariable(value = "id") Long merchantId) {
    Merchant merchant = merchantRepository.findById(merchantId)
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantId));

    merchantRepository.delete(merchant);

    return ResponseEntity.ok().build();
  }
}

package com.yalday.yaldayBoot.controller;

import com.yalday.yaldayBoot.entity.Merchant;
import com.yalday.yaldayBoot.exception.MerchantExistsException;
import com.yalday.yaldayBoot.exception.ResourceNotFoundException;
import com.yalday.yaldayBoot.repository.MerchantRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MerchantController {

  private final MerchantRepository merchantRepository;

  @Autowired
  public MerchantController(final MerchantRepository merchantRepository) {
    this.merchantRepository = merchantRepository;
  }

  @GetMapping(path="/merchants", produces="application/json")
  public List<Merchant> getAllMerchants() {
    System.out.println("MerchantController.getAllMerchants");
    return merchantRepository.findAll();
  }

  @PostMapping(path="/merchants")
  public Merchant createMerchant(@Valid @RequestBody Merchant merchant) {
    Optional<Merchant> optionalMerchant = merchantRepository.findByName(merchant.getName());
    optionalMerchant.ifPresent(returnedMerchant -> {throw new MerchantExistsException();});
    return merchantRepository.save(merchant);
  }

  @GetMapping("/merchants/{name}")
  public Merchant getMerchantByName(@PathVariable(value = "name") String name) {
    return merchantRepository.findByName(name)
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "name", name));
  }

  @PutMapping("/merchants")
  public Merchant updateMerchant(@Valid @RequestBody Merchant merchantDetails) {
    System.out.println("MerchantController.updateMerchant");
    Merchant merchant = merchantRepository.findById(merchantDetails.getId())
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", merchantDetails.getId()));
    merchant.setName(merchantDetails.getName());
    return merchantRepository.save(merchant);
  }

  @DeleteMapping("/merchants/{id}")
  public ResponseEntity<?> deleteMerchant(@PathVariable(value = "id") Long id) {
    Merchant merchant = merchantRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Merchant", "id", id));

    merchantRepository.delete(merchant);

    return ResponseEntity.ok().build();
  }
}

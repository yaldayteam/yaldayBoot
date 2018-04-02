package com.yalday.yaldayBoot.repository;
import com.yalday.yaldayBoot.repository.MerchantRepository;

import com.yalday.yaldayBoot.entity.Merchant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by Home on 25/03/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantRepositoryTest {


  @Autowired
  MerchantRepository merchantRepository;

 // @Test
 // public void updateTest() {

 // }

  @Test
  public void saveAndFindOneTest() {
    Merchant merchant = new Merchant();
    merchant.setId(124L);
    merchant.setName("TestMerchant");
    Assert.assertEquals(merchant.getName(), "TestMerchant");
    merchantRepository.save(merchant);
    Assert.assertNotNull(merchantRepository.findById(124L));
  }

  @Test
  public void findAllTest() {
    List<Merchant> merchantListBefore = merchantRepository.findAll();
    Assert.assertEquals(merchantListBefore.size(), 1);
  }

  @Test
  public void deleteTest() {
    List<Merchant> merchantListBefore1 = merchantRepository.findAll();
    Assert.assertEquals(merchantListBefore1.size(), 2);
    merchantRepository.delete(124L);
    List<Merchant> merchantListAfter2 = merchantRepository.findAll();
    Assert.assertEquals(merchantListAfter2.size(),1);
  }
}

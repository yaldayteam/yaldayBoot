package com.yalday.yaldayBoot.repository

import com.yalday.yaldayBoot.YaldayBootApplication
import com.yalday.yaldayBoot.entity.Merchant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = YaldayBootApplication.class)
class MerchantRepositorySpec extends Specification {

  @Autowired
  MerchantRepository merchantRepository

  void setup(){
      merchantRepository.deleteAll()
  }

  def "findAll returns all Merchants" (){
    given: "the merchant repository"
      Merchant merchant = new Merchant()
      merchant.setName("Good Burger")
      merchantRepository.save(merchant)
    when: "the find all method is called"
      def merchants = merchantRepository.findAll()
    then: "all the merchants are returned"
      merchants != null
      merchants.size() == 1
      merchants[0].name == "Good Burger"
  }

  def "find a merchant by their name"(){
    given: "Given a merchant with a name"
      Merchant merchant = new Merchant()
      def BIG_KAHUNA_BURGER = "Big Kahuna Burger"
      merchant.setName(BIG_KAHUNA_BURGER)
      merchantRepository.save(merchant)
    when: "I search the merchant repository for that merchant name"
       def optionalMerchant = merchantRepository.findByName(BIG_KAHUNA_BURGER)
    then: "I find the associated merchant"
      def returnedMerchant = optionalMerchant.get()
      returnedMerchant.getName() == BIG_KAHUNA_BURGER
  }

  def "deleting a merchant by their name removes them from the repo"(){
    given: "Give a merchant with a name"
      Merchant merchant = new Merchant()
      def STANS = "Stan Mikita's All Star Cafe"
      merchant.setName(STANS)
      merchantRepository.save(merchant)
    when: "I delete that merchant from the repo"
      merchantRepository.deleteByName(STANS)
    and: "I subsequently ask for that Merchant"
      def optionalMerchant = merchantRepository.findByName(STANS)
    then: "I expect the merchant to be removed from the repo"
      !optionalMerchant.isPresent()
  }


}

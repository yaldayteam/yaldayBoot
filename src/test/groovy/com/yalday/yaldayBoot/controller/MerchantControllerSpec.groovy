package com.yalday.yaldayBoot.controller

import com.yalday.yaldayBoot.YaldayBootApplication
import com.yalday.yaldayBoot.entity.Merchant
import com.yalday.yaldayBoot.exception.MerchantExistsException
import com.yalday.yaldayBoot.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = YaldayBootApplication.class)
class MerchantControllerSpec extends Specification {

  MerchantController merchantController

  @Autowired
  MerchantRepository merchantRepository

  def setup(){
    merchantController = new MerchantController(merchantRepository)
    merchantRepository.deleteAll()
  }

  def "creating a merchant is successful" (){
    given: "A create call received from the front end asking to create a new merchant"
      def DOUBLER = "RR Diner"
      Merchant merchant = new Merchant()
      merchant.setName(DOUBLER)
    when: "The endpoint is hit"
      merchantController.createMerchant(merchant)
    then: "I expect the merchant to exist in the repo"
      merchantRepository.count() == 1
  }

  def "creating a merchant which already exists throws an exception"(){
      given: "A create call is received for a merchant which already exists"
        def DOUBLER = "RR Diner"
        Merchant merchant = new Merchant()
        merchant.setName(DOUBLER)
        merchantRepository.save(merchant)
      when: "The endpooint is hit"
        merchantController.createMerchant(merchant)
      then: "I expect an exception to be thrown"
        thrown (MerchantExistsException)
      and: "There should be no new merchants in the repo"
        merchantRepository.count() == 1
  }
}

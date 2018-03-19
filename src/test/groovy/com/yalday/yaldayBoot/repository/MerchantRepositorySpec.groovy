package com.yalday.yaldayBoot.repository

import com.yalday.yaldayBoot.YaldayBootApplication
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

  }

  def "findAll returns all Merchants" (){
    given: "the merchant repository"
    when: "the find all method is called"
      def merchants = merchantRepository.findAll()
    then: "all the merchants are returned"
      merchants != null
      merchants.size() == 1
      merchants[0].name == "chris"
  }

}

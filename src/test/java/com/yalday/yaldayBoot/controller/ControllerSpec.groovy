package com.yalday.yaldayBoot.controller

import com.yalday.yaldayBoot.entity.Merchant
import com.yalday.yaldayBoot.repository.MerchantRepository
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Home on 25/03/2018.
 */


class ControllerSpec extends Specification {

  def repository = Mock(MerchantRepository);

  def @Subject api = new MerchantController(merchantRepository: repository)

  def mockMvc = MockMvcBuilders.standaloneSetup(api).build()

  def 'should call get all merchants'() {
    when:
    def result = mockMvc.perform(get('/merchants'))
    then:
    1 * repository.findAll() >> [new Merchant(124, 'TestMerchant')]
    result.andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string('[{"id":124,"name":"TestMerchant"}]'))
  }

}

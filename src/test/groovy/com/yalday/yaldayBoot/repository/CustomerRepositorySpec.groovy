package com.yalday.yaldayBoot.repository

import com.yalday.yaldayBoot.YaldayBootApplication
import com.yalday.yaldayBoot.entity.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = YaldayBootApplication.class)
class CustomerRepositorySpec extends Specification {

  public static final String USER_NAME = "Kel"
  @Autowired
  CustomerRepository userRepository

  void setup(){
    userRepository.deleteAll()
  }

  def "findAll returns all Users" (){
    given: "the user repository"
      Customer user = new Customer()
      user.setUsername(USER_NAME)
      userRepository.save(user)
    when: "the find all method is called"
      def users = userRepository.findAll()
    then: "all the users are returned"
      users != null
      users.size() == 1
      users[0].username == USER_NAME
  }

  def "find a user by their name"(){
    given: "Given a user with a username"
      Customer user = new Customer()
      user.setUsername(USER_NAME)
      userRepository.save(user)
    when: "I search the user repository for that merchant username"
      def optionalUser = userRepository.findByUsername(USER_NAME)
    then: "I find the associated user"
      def returnedUser = optionalUser.get()
      returnedUser.getUsername() == USER_NAME
  }

  def "deleting a user by their name removes them from the repo"(){
    given: "Give a user with a username"
      Customer user = new Customer()
      user.setUsername(USER_NAME)
      userRepository.save(user)
    when: "I delete that user from the repo"
      userRepository.deleteByUsername(USER_NAME)
    and: "I subsequently ask for that Merchant"
      def optionalUser = userRepository.findByUsername(USER_NAME)
    then: "I expect the user to be removed from the repo"
      !optionalUser.isPresent()
  }
}

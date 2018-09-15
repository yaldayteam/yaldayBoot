package com.yalday.yaldayBoot.controller

import com.yalday.yaldayBoot.YaldayBootApplication
import com.yalday.yaldayBoot.entity.Customer
import com.yalday.yaldayBoot.exception.UserExistsException
import com.yalday.yaldayBoot.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = YaldayBootApplication.class)
class CustomerControllerSpec extends Specification {

  CustomerController userController

  @Autowired
  CustomerRepository userRepository

  def setup(){
    userController = new CustomerController(userRepository)
    userRepository.deleteAll()
  }

  def "creating a user is successful" (){
    given: "A create call received from the front end asking to create a new user"
      def USER = "Eric"
      Customer user = new Customer()
      user.setUsername(USER)
    when: "The endpoint is hit"
      userController.createUser(user)
    then: "I expect the user to exist in the repo"
      userRepository.count() == 1
  }

  def "creating a user which already exists throws an exception"(){
    given: "A create call is received for a user which already exists"
      def USER = "Eric"
      Customer user = new Customer()
      user.setUsername(USER)
      userRepository.save(user)
    when: "The endpoint is hit"
      userController.createUser(user)
    then: "I expect an exception to be thrown"
      thrown (UserExistsException)
    and: "There should be no new users in the repo"
      userRepository.count() == 1
  }

  def "updating a user is successful" (){
    given: "a user already exists in the database"
      def USER = "Eric"
      Customer user = new Customer()
      user.setUsername(USER)
      userRepository.save(user)
    and: "I change the username of the user"
      Customer newUser = new Customer()
      newUser.setUsername("Zlatan")
    when: "I update a property of that merchant"
      Customer updatedUser = userController.updateUser(newUser)
    then: "I expect the new value to be updated in the database"
      updatedUser.getUsername() == "Zlatan"
  }

  def "deleting a user is successful" (){
    given: "a user exists in the database"
      Customer user = new Customer()
      user.setUsername("Iniesta")
      userRepository.save(user)
    when: "I delete that user"
      userRepository.delete(merchant)
    then: "I expect it to be deleted from the database"
      userRepository.count() == 0
  }
}

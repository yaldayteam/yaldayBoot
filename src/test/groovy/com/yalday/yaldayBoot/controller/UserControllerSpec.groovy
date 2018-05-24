package com.yalday.yaldayBoot.controller

import com.yalday.yaldayBoot.YaldayBootApplication
import com.yalday.yaldayBoot.entity.Merchant
import com.yalday.yaldayBoot.entity.User
import com.yalday.yaldayBoot.exception.MerchantExistsException
import com.yalday.yaldayBoot.exception.UserExistsException
import com.yalday.yaldayBoot.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = YaldayBootApplication.class)
class UserControllerSpec extends Specification {

  UserController userController

  @Autowired
  UserRepository userRepository

  def setup(){
    userController = new UserController(userRepository)
    userRepository.deleteAll()
  }

  def "creating a user is successful" (){
    given: "A create call received from the front end asking to create a new user"
      def USER = "Eric"
      User user = new User()
      user.setName(USER)
    when: "The endpoint is hit"
      userController.createUser(user)
    then: "I expect the user to exist in the repo"
      userRepository.count() == 1
  }

  def "creating a user which already exists throws an exception"(){
    given: "A create call is received for a user which already exists"
      def USER = "Eric"
      User user = new User()
      user.setName(USER)
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
      User user = new User()
      user.setName(USER)
      userRepository.save(user)
    and: "I change the name of the user"
      User newUser = new User()
      newUser.setName("Zlatan")
    when: "I update a property of that merchant"
      User updatedUser = userController.updateUser(newUser)
    then: "I expect the new value to be updated in the database"
      updatedUser.getName() == "Zlatan"
  }

  def "deleting a user is successful" (){
    given: "a user exists in the database"
      User user = new User()
      user.setName("Iniesta")
      userRepository.save(user)
    when: "I delete that user"
      userRepository.delete(merchant)
    then: "I expect it to be deleted from the database"
      userRepository.count() == 0
  }
}

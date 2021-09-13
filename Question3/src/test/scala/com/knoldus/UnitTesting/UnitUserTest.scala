package com.knoldus.UnitTesting

import com.knoldus.company.UserModel
import com.knoldus.validates.UserValidates
import org.scalatest.flatspec.AsyncFlatSpec

class UnitUserTest extends AsyncFlatSpec {

  val userValidator = new UserValidates()

  val user1: UserModel = UserModel("Gulshan Singh", "gulshan16@gmail.com", "Noida", "Knoldus")
  val user2: UserModel = UserModel("Shubham Gupta", "subham@gmail.coom", "Noida", "TCS")
  val user3: UserModel = UserModel("Fabeeh", "fabeeha.com", "Noida", "Accenture")
  val user4: UserModel = UserModel("gulshan", "gulshan1216@gmail123.com", "Noida", "TCS")

  // Testing the UserImplementation and User Validation
  "User" should " be valid as user company  exists in Database" in {
    val result = userValidator.isValidUser(user1)
    assert(result)
  }

  // USer Email Validation
  "User email Id " should "be valid " in {
    val result = userValidator.isValidEmail(user1)
    assert(result)
  }

  "User email id" should "not be valid as it contains invalid top lavel domain" in {
    val result = userValidator.isValidEmail(user2)
    assert(!result)
  }

  "Email Id without @" should "be invalid " in {
    val result= userValidator.isValidEmail(user3)
    assert(!result)
  }

  "Email Id with alphanumeric name and domain name" should "be valid " in {
    val result= userValidator.isValidEmail(user4)
    assert(result)
  }
}

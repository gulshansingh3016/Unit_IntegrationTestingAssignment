package com.knoldus.userValidatesTest

import com.knoldus.company.UserModel
import com.knoldus.validates.UserValidates
import org.scalatest.flatspec.AnyFlatSpec

class UserValidateTest extends AnyFlatSpec {

  val userValidator:UserValidates=new UserValidates()

  behavior of  "this user"

  it should "be valid as its company exist in database and the email id is also written in correct format" in{
    val user:UserModel= UserModel("Gulshan","Singh","gulshan16@gmail.com","Knoldus")
    assert(userValidator.isValidUser(user))
  }

  it should "not be valid as its company does not exist in database and the email id is also invalid" in{
    val user:UserModel= UserModel("Sam","Singh","sam@gm@ail.com","Google")
    assert(!userValidator.isValidUser(user))
  }

  it should "not be valid as its email id is invalid" in{
    val user:UserModel= UserModel("Shaurya","Singh","sb11@gmail..com","Knoldus")
    assert(!userValidator.isValidEmail(user))
  }

  it should "not be valid as its company does not exist in database" in{
    val user:UserModel= UserModel("Fabeeha","Javed","fab@gmail.com","HCL")
    assert(!userValidator.isValidUser(user))
  }

}
package com.knoldus.emailTest

import com.knoldus.validates.EmailValidater
import org.scalatest.flatspec.AnyFlatSpec

class EmailTest extends AnyFlatSpec{
  val emailValidator = new EmailValidater()

  // Unit Test cases for Validation of Email
  "Email" should "be valid" in {
    val result = emailValidator.emailIdIsValid("Gulshan123@example45.com")
    assert(result)
  }

  "Email Id" should "be Valid alphanumeric domain" in {
    val result = emailValidator.emailIdIsValid("gulshan@example12.net")
    assert(result)
  }
  "Email Id with wrong Recipient name" should "be invalid" in {
    val result = emailValidator.emailIdIsValid( "##gulshan@yahoo.net")
    assert(!result)
  }

  "Email Id missing @ symbol" should "be invalid" in {
    val result = emailValidator.emailIdIsValid("gulshan.com")
    assert(!result)
  }
  "Email Id with wrong domain name" should "be invalid" in {
    val result =emailValidator.emailIdIsValid("gulshan@!yahoo.com")
    assert(!result)
  }
  "Email Id with wrong Top_Level Domain Name" should "be invalid" in {
    val result = emailValidator.emailIdIsValid("gulshan@yahoo.ccom")
    assert(!result)
  }
}


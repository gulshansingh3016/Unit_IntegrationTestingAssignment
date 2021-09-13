package com.knoldus.IntegrationTesting

import com.knoldus.company.{CompanyModel, UserModel}
import com.knoldus.validates.{CompanyValidates, UserValidates}
import org.scalatest.flatspec.AsyncFlatSpec

class IntegrationTestingCompanyUser extends AsyncFlatSpec{

  // Testing CompanyImplementation and CompanyValidation

  val companyValidator: CompanyValidates = new CompanyValidates()
  val userValidator = new UserValidates()

  val testComapny1: CompanyModel = CompanyModel("infosys", "sony@sony.com", "Noida")
  val testComapny2: CompanyModel = CompanyModel("Knoldus", "knoldus14@gmail.com", "Noida")
  val testComapny3: CompanyModel = CompanyModel("Philips", "Philips@sony.hi", "Noida")
  val testComapny4: CompanyModel = CompanyModel("Sony", "sonysony.com", "Noida")

  val user1: UserModel = UserModel("Gulshan Singh", "gulshan@gmail.com", "Noida", "Knoldus")
  val user2: UserModel = UserModel("Shubham ", "shubham@gmail.coom", "Noida", "TCS")
  val user3: UserModel = UserModel("sony", "sony$123@sony.com", "Noida", "Accenture")

  // Company should not exists in database
  "Company" should " not be valid as it exists in Database" in {
    val result = companyValidator.IsValidCompany(testComapny1)
    assert(result)
  }

  "Company" should "not be exists in Database" in {
    val result = companyValidator.IsValidCompany(testComapny2)
    assert(!result)
  }

  // Email Validation
  "Email Id " should "be valid " in {
    val result= companyValidator.isValidEmail(testComapny2)
    assert(result)
  }

  "Email Id with wrong top level domain" should "not be valid" in {
    val result = companyValidator.isValidEmail(testComapny3)
    assert(!result)
  }

  "Email Id without @" should "be invalid " in {
    val result= companyValidator.isValidEmail(testComapny4)
    assert(!result)
  }

  // Testing the UserImplementation and User Validation
  "User" should " be valid as user company it exists in Database" in {
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

}
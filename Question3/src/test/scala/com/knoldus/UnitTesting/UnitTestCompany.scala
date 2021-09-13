package com.knoldus.UnitTesting

import com.knoldus.company.CompanyModel
import com.knoldus.validates.{CompanyValidates, UserValidates}
import org.scalatest.flatspec.AsyncFlatSpec

class UnitTestCompany
  extends AsyncFlatSpec {

    val companyValidator: CompanyValidates = new CompanyValidates()
    val userValidator = new UserValidates()

    val testComapny1: CompanyModel = CompanyModel("google", "google@google.com", "USA")
    val testComapny2: CompanyModel = CompanyModel("Knoldus", "knoldus14@gmail.com", "Noida")
    val testComapny3: CompanyModel = CompanyModel("TCS", "!!tcs123@tcs.com", "Noida")
    val testComapny4: CompanyModel = CompanyModel("Sony", "sonysony.hello", "Noida")

    // Company should not exists in database
    "Company" should " not be exists in Database" in {
      val result = companyValidator.IsValidCompany(testComapny1)
      assert(result)
    }

    "It " should "return false if company exists in Database" in {
      val result = companyValidator.IsValidCompany(testComapny2)
      assert(!result)
    }

    // Company email Validation
    "Email Id " should "be valid " in {
      val result= companyValidator.isValidEmail(testComapny2)
      assert(result)
    }

    "Email Id with wrong recipient" should "not be valid" in {
      val result = companyValidator.isValidEmail(testComapny3)
      assert(!result)
    }

    "Email Id without @" should "be invalid " in {
      val result= companyValidator.isValidEmail(testComapny4)
      assert(!result)
    }

    "Email Id with wrong top level domain " should "be invalid " in {
      val result= companyValidator.isValidEmail(testComapny4)
      assert(!result)
    }

  }



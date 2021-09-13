package com.knoldus.CompanyTestValidates

import com.knoldus.company.CompanyModel
import com.knoldus.database.CompanyData
import com.knoldus.validates.CompanyValidates
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatesTest extends AnyFlatSpec {

  val companyValidator:CompanyValidates=new CompanyValidates()

  behavior of "this company"
  it should "be valid as it does not exist in database and the email id is also written in correct format" in{
    val company:CompanyModel = CompanyModel("HCL","hcl@gmail.com","Pune")
    assert(companyValidator. IsValidCompany(company))
  }

  it should "not be valid as it already exist in database and the email id is also invalid" in{
    val company:CompanyModel = CompanyModel("Philips","philip12@gma@il.com","Noida")
    assert(!companyValidator.isValidEmail(company))
  }

  it should "not be valid as it already exists in database" in{
    val company:CompanyModel = CompanyModel("Knoldus", "knoldus@gmail.com", "Noida")
    assert(!companyValidator.isValidEmail(company))
  }

  it should "not be valid as it's email id is invalid" in{
    val company:CompanyModel = CompanyModel("accenture","acc123@@gmail.com","Noida")
    assert(!companyValidator.IsValidCompany(company))
  }

}

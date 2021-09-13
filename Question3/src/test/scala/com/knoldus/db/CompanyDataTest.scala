package com.knoldus.db

import com.knoldus.database.CompanyData
import org.scalatest.flatspec.AnyFlatSpec

class CompanyDataTest extends AnyFlatSpec {

  val companyReadDto:CompanyData =new CompanyData()

  behavior of "getCompanyByName method"

  it should "return the company" in{

    val result= companyReadDto.getCompanyByName("Knoldus")
    assert(result.isDefined)
  }

  it should "not return the company as this company does not exist" in {

    val result= companyReadDto.getCompanyByName("Google")
    assert(result.isEmpty)
  }


}

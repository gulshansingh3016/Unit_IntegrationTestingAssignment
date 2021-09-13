package com.knoldus.database

import com.knoldus.company.CompanyModel

import scala.collection.immutable.HashMap

class CompanyData {
  val knoldusCompany: CompanyModel = CompanyModel("Knoldus", "knoldus@gmail.com", "Noida")
  val Philips: CompanyModel = CompanyModel("Philips", "Philips@gmail.com", "Noida")
  val companies: HashMap[String, CompanyModel] = HashMap("Knoldus" -> knoldusCompany, "Philips" -> Philips)

  def getCompanyByName(name: String): Option[CompanyModel] = companies.get(name)
}
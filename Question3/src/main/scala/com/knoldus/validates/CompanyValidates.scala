package com.knoldus.validates

import com.knoldus.company.CompanyModel
import com.knoldus.database.CompanyData


class CompanyValidates {

    def IsValidCompany(company: CompanyModel): Boolean = {
      // company should not exist in db
      val companyRead = new CompanyData()
      val dbResult: Option[CompanyModel] = companyRead.getCompanyByName(company.name)
      if (dbResult.isEmpty) return true

      false
    }

    def isValidEmail(company: CompanyModel): Boolean ={
      // email should be valid
      val emailValidator = new EmailValidater()
      val emailValidatorResult = emailValidator.emailIdIsValid(company.emailId)

      if(emailValidatorResult) return true

      false
    }
  }


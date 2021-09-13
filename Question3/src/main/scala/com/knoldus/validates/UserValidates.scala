package com.knoldus.validates

import com.knoldus.company.{CompanyModel, UserModel}
import com.knoldus.database.{CompanyData, UserData}

class UserValidates {
  def isValidUser(user: UserModel): Boolean = {
    // company should exist in db
    val userRead = new UserData()

    val companyRead = new CompanyData()
    val dbResult: Option[CompanyModel] = companyRead.getCompanyByName(user.companyName)

    if (dbResult.isDefined)
      return true
    false
  }


  // email should be valid
  def isValidEmail(user: UserModel): Boolean ={
    val emailValidator = new EmailValidater()
    val emailValidatorResult = emailValidator.emailIdIsValid(user.emailId)

    if(emailValidatorResult)
      return true
    false
  }

}

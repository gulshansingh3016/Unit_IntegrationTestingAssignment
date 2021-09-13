package com.knoldus.validates

class EmailValidater
  {
    // check the email is valid by matching with regular expression
    def emailIdIsValid(emailId: String): Boolean = {
      """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+(com|net|org)""".r.unapplySeq(emailId).isDefined
    }

  }


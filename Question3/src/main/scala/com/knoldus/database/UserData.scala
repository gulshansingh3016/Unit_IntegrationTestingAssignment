package com.knoldus.database

import com.knoldus.company.UserModel

import scala.collection.immutable.HashMap

class UserData {
  val user1: UserModel = UserModel("Aasif Ali", "knoldus@gmail.com", "Noida", "Knoldus")
  val user2: UserModel = UserModel("Mayank", "knoldus@gmail.com", "Noida", "Infosys")

  val users: HashMap[String, UserModel] = HashMap("user1" -> user1, "user2" -> user2)

  def getUserByName(name: String): Option[UserModel] = users.get(name)
}

package com.ningen.gomi.user

case class User
(id: Int, 
 email: String, 
 firstName: String, 
 lastName: String)

trait Users {

  this: UserRepositoryComponent =>

  def getUser(id: Int): User = userRepository.get(id)

  def findUser(username: String): User = userRepository.find(username)

}

trait UserInfo extends Users {

  this: UserRepositoryComponent =>

  def userEmail(id: Int): String = getUser(id).email

  def userInfo(username: String): Map[String, String] = {
    val user = findUser(username)
    Map(
      "fullName" -> s"${user.firstName} ${user.lastName}",
      "email" -> s"${user.email}")
  }
  
}

object UserInfoImpl extends UserInfo with UserRepositoryComponentImpl

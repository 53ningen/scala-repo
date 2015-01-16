package com.ningen.gomi.monadicuser

import scalaz.Reader

case class User(id: Int, firstName: String, lastName: String, email: String)

trait Users {

  import scalaz.Reader

  def getUser(id: Int): Reader[Config, User] = Reader((config: Config) => config.userRepository.get(id))

  def findUser(username: String): Reader[Config, User] = Reader((config: Config) => config.userRepository.find(username))

}

object UserInfo extends Users {
  
  def userEmail(id: Int) = getUser(id) map(_.email)
  
  def userInfo(username: String) = for {
    user <- findUser(username)
  } yield Map(
      "fullName" -> s"${user.firstName} ${user.lastName}",
      "email" -> user.email
    )
}

object UserClient extends UserRepositoryImpl

class UserClient(userRepository: UserRepository) {
  
  private def run[A](reader: Reader[UserRepository, A]): A = reader(userRepository)
  
  
}

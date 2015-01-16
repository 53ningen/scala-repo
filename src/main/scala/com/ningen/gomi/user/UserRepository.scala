package com.ningen.gomi.user

trait UserRepositoryComponent {

  def userRepository: UserRepository

  trait UserRepository {

    def get(id: Int): User

    def find(username: String): User

  }

}

trait UserRepositoryComponentImpl extends UserRepositoryComponent {
  
  def userRepository = new UserRepositoryImpl
  
  class UserRepositoryImpl extends UserRepository {
    
    def get(id: Int) = User(id, id.toString, id.toString, id.toString)

    def find(username: String) = User(1, username, username, username)

  }

}


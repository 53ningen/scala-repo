package com.ningen.gomi.monadicuser

trait UserRepository {
  
  def get(id: Int): User
  
  def find(username: String): User

}

trait UserRepositoryImpl
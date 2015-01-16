package com.ningen.gomi.readermonad.client

import java.sql.Connection

class ClientImpl {

  def setUserPassword(id: String, password: String): Connection => Unit = c => {
    val stmt = c.prepareStatement("update users set pwd = ? where id = ?")
    stmt.setString(1, password)
    stmt.setString(2, id)
    stmt.executeUpdate()
    stmt.close()
  }

  case class DB[A](g: Connection => A) {
    def apply(c: Connection): A = g(c)

    def map[B](f: A => B): DB[B] = DB(c => f(g(c)))

    def flatMap[B](f: A => DB[B]): DB[B] = DB(c => f(g(c))(c))
  }

  def pure[A](a: A): DB[A] = DB(c => a)

}




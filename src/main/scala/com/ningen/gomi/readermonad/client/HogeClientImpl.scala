package com.ningen.gomi.readermonad.client

import java.sql.{Connection, DriverManager}

class HogeClientImpl {
  
  def setUserPassword(id: String, password: String): Connection => Unit = c => {
    val stmt = c.prepareStatement("update users set pwd = ? where id = ?")
    stmt.setString(1, password)
    stmt.setString(2, id)
    stmt.executeUpdate()
    stmt.close()
  }

}

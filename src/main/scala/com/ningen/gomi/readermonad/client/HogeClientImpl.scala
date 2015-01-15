package com.ningen.gomi.readermonad.client

import java.sql.DriverManager

class HogeClientImpl {
  
  def setUserPassword(id: String, password: String): Unit = {
    Class.forName("org.sqlite.JDBC")
    val c = DriverManager.getConnection("jdbc:sqlite:memory:")
    val stmt = c.prepareStatement("update users set pwd = ? where id = ?")
    stmt.setString(1, password)
    stmt.setString(2, id)
    stmt.executeUpdate()
    c.commit()
    c.close()
  }

}

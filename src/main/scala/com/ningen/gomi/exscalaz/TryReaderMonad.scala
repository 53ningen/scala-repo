package com.ningen.gomi.exscalaz

import scalaz._
import Scalaz._

class TryReaderMonad {

  /**
   * Reader Monad の使い方を学ぶメソッド
   * @return いろいろ計算した値
   */
  def getInt: Int = {
    val f1 = for {
      a <- 2 * (_: Int)
      b <- 10 + (_: Int)
    } yield a + b

    f1(4)
  }

}

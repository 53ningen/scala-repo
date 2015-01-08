package com.ningen.gomi.exscalaz

class TryReaderMonadTest extends org.specs2.mutable.Specification {

  "TryReaderMonad" should {
    
    val reader = new TryReaderMonad
    
    "getInt" in {
      reader.getInt mustEqual 22
    }
    
  }

}

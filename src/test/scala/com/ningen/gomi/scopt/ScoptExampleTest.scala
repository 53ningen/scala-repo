package com.ningen.gomi.scopt

import org.specs2.mutable.Specification

class ScoptExampleTest extends Specification {
  
  val scopt = new ScoptExample
  
  "ScoptExample" should {
    
    "parseできる" in {
      
      val args = Seq()
      
      val retval = scopt.parser.parse(args, Config()) match {
        case Some(config) => 10 
        case _ => 20
      }
      
      retval mustEqual 10
      
    }
    
  }
  

}

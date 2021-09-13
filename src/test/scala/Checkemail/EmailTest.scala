package Checkemail

import org.scalatest.funsuite.AnyFunSuite

class EmailTest extends AnyFunSuite{


  val checkemail = new Email
  test("Checking the valid reciepient name"){
    val expectedresult = true
    val actualresult = checkemail.checkrecipientname("bobbamohanasaikumarreddy1@gmail.com")
    assert(expectedresult == actualresult)

  }
  test("Checking the invalid reciepient name"){
    val expectedresult = false
    val actualresult = checkemail.checkrecipientname("bobbamoha__nasaikumarreddy1@gmail.com")
    assert(expectedresult == actualresult)
  }
  test("'@' is present in Emailid"){

    val expectedValue= true
    val result = checkemail.checkAtTheRate("pramanikdipayan007@gmail.com")
    assert(result == expectedValue)
  }


  test("'@' is not present in the emailid"){
    intercept[IllegalArgumentException]{
      checkemail.checkAtTheRate("dipayan23gmail.com")
    }
  }
  test("Check that Domain Name does not contain special characters"){

    val expectedValue= true
    val result = checkemail.domainName("pramanikdipayan007@gmail.com")
    assert(result == expectedValue)
  }


  test("Domain Name with Special Characters throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      checkemail.domainName("dipayan23@gmail#23.com")
    }
  }


  test("Check Top Level Domains are .com/.net/.org"){

    val expectedValue= true
    val result = checkemail.topLevelDomain("pramanikdipayan007@gmail.com")
    assert(result == expectedValue)
  }

  test("If Top Level Domain is not .net/.org/.com it throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      checkemail.topLevelDomain("dipayan23@gmail.co.in")
    }
  }
}


package Checkemail

class Email {
  def checkrecipientname(email: String): Boolean = {
    for(i <- 0 until(email.length)){

      val ch = email.charAt(i)
      if (ch == '@')
        return true
      if (!ch.isDigit && !ch.isLetter)
        return false
    }
    false
  }

  def checkAtTheRate(email: String): Boolean = {
    for (i <- 0 until  email.length)
      if (email.charAt(i) == '@')
        return true

    throw new IllegalArgumentException("'@' in the Email ID is missing")
  }

  def domainName(email: String): Boolean = {

    if(!checkAtTheRate(email)) return false
    var index = email.indexOf("@") + 1
    while (email.charAt(index) != '.') {
      if (!Character.isLetterOrDigit(email.charAt(index))) throw new IllegalArgumentException("Domain Name is not alphanumeric")
      index = index + 1
    }
    true
  }

  def topLevelDomain(email: String): Boolean = {

    if(!checkAtTheRate(email)) return false
    val index = email.indexOf(".")
    val toplevelDomain = email.substring(index)
    if (toplevelDomain.equals(".com") || toplevelDomain.equals(".net") || toplevelDomain.equals(".org"))
      return true
    throw new IllegalArgumentException("Invalid Top Level Domain")

  }
}

/*Recipient name -  alphanumeric characters (both lower and upper case)
ii. @ symbol
iii. Domain name – alphanumeric (both lower and upper case)
iv. Top-level domain - .com/.net/.org
mohanareddy@knoldus.com*/


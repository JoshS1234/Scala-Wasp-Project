import Exceptions.NonIntegerResponseException

import scala.io.StdIn.readLine
import scala.util.matching.Regex

object PlayerMessages {



  private def getPlayerTurnResponse(message: String): Int = {
    var validAnswer = false;
    val numberPattern: Regex = "^[1-2]$".r

    while (!validAnswer) {
      println(message)
      val userAnswer = readLine()
      numberPattern.findFirstMatchIn(userAnswer) match {
        case None => {}
        case Some(value) => {
          validAnswer=true;
          userAnswer.toInt;
        };
      }
    }
  0
  }

  def playerTurn() : Int = {
    val choice = PlayerMessages.getPlayerTurnResponse("You may do one of the following: \n1. Hit a wasp \n2. Quit \nEnter your choice (enter 1 or 2): ")
    choice
  }


}

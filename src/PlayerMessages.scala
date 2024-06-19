import Exceptions.NonIntegerResponseException

import scala.io.StdIn.readLine
import scala.util.matching.Regex

object PlayerMessages {

  private def getPlayerTurnResponse(message: String): Int = {
    var validAnswer = false;
    val numberPattern: Regex = "^[1-3]$".r
    var finalAnswer : Int = 0

    while (!validAnswer) {
      println(message)
      val userAnswer = readLine()
      numberPattern.findFirstMatchIn(userAnswer) match {
        case None => {}
        case Some(value) => {
          validAnswer=true;
          finalAnswer = userAnswer.toInt;
        };
      }
    }
  finalAnswer
  }

  private def getPlayerReplayResponse(message: String): Int = {
    var validAnswer = false;
    val numberPattern: Regex = "^[1-2]$".r
    var finalAnswer : Int = 0

    while (!validAnswer) {
      println(message)
      val userAnswer = readLine()
      numberPattern.findFirstMatchIn(userAnswer) match {
        case None => {}
        case Some(value) => {
          validAnswer=true;
          finalAnswer = userAnswer.toInt;
        };
      }
    }
    finalAnswer
  }

  def playerTurn() : Int = {
    val choice = PlayerMessages.getPlayerTurnResponse("You may do one of the following: \n1. Hit a wasp \n2. Quit \n3. Switch on autofire \nEnter your choice (enter 1, 2 or 3): ")
    choice
  }

  def replayGameMessage() : Int = {
    val choice = PlayerMessages.getPlayerReplayResponse("Would you like to play again? \n1. Yes \n2. No \nEnter your choice (enter 1 or 2): ")
    choice
  }

  private def getPlayerNameResponse(message: String): String = {
    var validAnswer = false;
    val numberPattern: Regex = "^[a-zA-Z]+$".r
    var finalAnswer = ""

    while (!validAnswer) {
      println(message)
      val userAnswer = readLine()
      numberPattern.findFirstMatchIn(userAnswer) match {
        case None => {}
        case Some(value) => {
          validAnswer=true;
          finalAnswer = userAnswer
        };
      }
    }
    finalAnswer.toUpperCase
  }

  def playerIntro() : Int = {
    val choice = PlayerMessages.getPlayerTurnResponse("Welcome to the wasp-slaying game! \nFirstly, I will need to know your name \nEnter your name below (alphabet characters only): ")
    choice
  }


}

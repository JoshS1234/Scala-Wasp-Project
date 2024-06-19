import Wasps.{Nest, Wasp}

import scala.util.control.Breaks.break

object GameLogic extends App {

  var nest : Nest = new Nest();
//  println(new WaspQueen().displayImage)
  runGame()



  def runGame() : Unit = {
    setupGame()
    playGame()
  }


  def setupGame() : Unit = {
    nest = new Nest();
    nest = nest.populateNest()
    nest.displayWasps()
  }

  def playGame() : Unit = {
    var autofire=false;
    var turns : Int = 1
    while (nest.hasWasps) {
      println("_".repeat(10))
      println("Turn number "+ turns)


      if (!autofire) {
        var playerTurnChoice : Int = PlayerMessages.playerTurn()
        if (playerTurnChoice == 1) {
          attackTurn()
        } else if (playerTurnChoice ==2 ) {
          println("Quitting game...")
          break
        }  else if (playerTurnChoice ==3 ) {
          println("Auto-fire switched on")
          autofire=true;
        } else {
          throw new Exception("Something went wrong")
        }
      } else {
        attackTurn()
      }
      turns = turns + 1
    }

    val replayChoice : Int = PlayerMessages.replayGameMessage()
    if (replayChoice == 1) {
      runGame()
    } else {
      println("Quitting game...")
    }
  }

  def attackTurn() : Unit = {
    nest =  nest.hitRandomWasp()
    if (!nest.hasQueen) {
      nest = nest.killAllWasps()
    } else {
      summary()
    }
    nest = nest.removeDeadWasps()
  }

  def summary() : Unit = {
    nest.displayWasps()
  }





}

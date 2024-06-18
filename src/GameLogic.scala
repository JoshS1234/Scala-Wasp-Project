import scala.util.control.Breaks.break

object GameLogic extends App {

  var nest : Nest = new Nest();
  runGame()



  def runGame() : Unit = {
    setupGame()
    playGame()
  }


  def setupGame() : Unit = {
    nest = new Nest();
    nest = nest.populateNest()
    nest.displayWasps()
    println(nest.selectRandomWasp().describe)
  }

  def playGame() : Unit = {
    while (nest.hasWasps) {
      var playerTurnChoice : Int = PlayerMessages.playerTurn()
      if (playerTurnChoice == 1) {
        attackTurn()
      } else if (playerTurnChoice ==2 ) {
        println("Quitting game...")
        break
      } else {
        throw new Exception("Something went wrong")
      }
    }

    var replayChoice : Int = PlayerMessages.replayGameMessage()
    if (replayChoice == 1) {
      runGame()
    } else {
      println("Quitting game...")
    }
  }

  def attackTurn() : Unit = {
    val waspToHit : Wasp = nest.selectRandomWasp()
    waspToHit.getHit()
    if (waspToHit.getClass.getSimpleName == "WaspQueen" && !waspToHit.isAlive) {
      nest = nest.killAllWasps()
    }
    nest = nest.removeDeadWasps()
    summary()
  }

  def summary() : Unit = {
    nest.displayWasps()
  }





}

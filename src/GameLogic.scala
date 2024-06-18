object GameLogic extends App {

  var nest = new Nest();
  nest = nest.populateNest()
  nest.displayWasps()

  println(nest.selectRandomWasp().describe)
  PlayerMessages.playerTurn()




}

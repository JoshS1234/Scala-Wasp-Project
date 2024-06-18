class Nest(waspsInNest : Array[Wasp] = new Array[Wasp](0)) {

  def addWasp(wasp: Wasp) : Nest = {
    val newNest = waspsInNest :+ wasp
    new Nest(newNest)
  }

  def displayWasps() : Unit = {
    for (wasp <- waspsInNest) {
      println(wasp.describe)
    }
  }

  def populateNest() : Nest = {
    var nest = new Nest();
    nest = nest.addWasp(new WaspQueen())
    for (i<-Range(0,5)) {
      nest = nest.addWasp(new WorkerWasp())
    }
    for (i<-Range(0,8)) {
      nest = nest.addWasp(new WaspDrone())
    }
    nest
  }

  def selectRandomWasp() : Wasp = {
    val randomIndex : Int = (Math.floor(Math.random() * waspsInNest.length).toInt)
    waspsInNest.lift(randomIndex).get
  }

  def hasWasps : Boolean = {
    if (waspsInNest.length != 0) true
    else false
  }

  def removeDeadWasps() : Nest = {
    new Nest(waspsInNest.filter(wasp => wasp.isAlive))
  }

  def killAllWasps() : Nest = {
    val deadWasps = waspsInNest.map(wasp => {
      wasp.isAlive = false
      wasp
    }) : Array[Wasp]
    new Nest(deadWasps)
  }




}

package Wasps

import Wasps.WaspWorker


class Nest(waspsInNest : Array[Wasp] = new Array[Wasp](0)) {

  def addWasp(wasp: Wasp) : Nest = {
    val newNest = waspsInNest :+ wasp
    new Nest(newNest)
  }

  def displayWasps() : Unit = {
    for (wasp<-waspsInNest) {
      println(wasp.describe)
//      println(wasp.displayImage)
    }

  }

  def populateNest() : Nest = {
    var nest = new Nest();
    nest = nest.addWasp(new WaspQueen())
    for (i<-Range(0,5)) {
      nest = nest.addWasp(new WaspWorker())
    }
    for (i<-Range(0,8)) {
      nest = nest.addWasp(new WaspDrone())
    }
    nest
  }

  def hitRandomWasp() : Nest = {
    val randomIndex : Int = (Math.floor(Math.random() * waspsInNest.length).toInt)
    val updatedRandomWasp : Wasp = waspsInNest.lift(randomIndex).get.getHit;
    var updatedWaspsInNest : Array[Wasp] = waspsInNest.slice(0, randomIndex)
    updatedWaspsInNest = updatedWaspsInNest :+ updatedRandomWasp
    for (wasp <- waspsInNest.slice(randomIndex+1, waspsInNest.length)) {
      updatedWaspsInNest = updatedWaspsInNest :+ wasp
    }
    new Nest(updatedWaspsInNest)


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
      wasp.setHP(0)
    }) : Array[Wasp]
    new Nest(deadWasps)
  }

  def hasQueen : Boolean = {
    var queenAlive = false;
    for (wasp<-waspsInNest) {
      if (wasp.getClass.getSimpleName=="WaspQueen") {
        queenAlive=wasp.getHitpoints>0;
      }
    }
    queenAlive
  }



}

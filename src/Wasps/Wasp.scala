package Wasps

import java.util.UUID

abstract class Wasp(hitpoints : Int) {

  val id : UUID = UUID.randomUUID()
  val damagePerHit : Int
//  var isAlive : Boolean = true

  def getHit : Wasp

  def die : Unit = println(s"A ${this.getClass.getSimpleName} has died")

  def describe : String = {
    s"This ${this.getClass.getSimpleName} has ${hitpoints}HP and takes ${damagePerHit} damage per hit"
  }

  def displayImage : String

  def isAlive : Boolean = {
    if (hitpoints>0) true
    else false
  }

  def getHitpoints : Int = hitpoints

  def setHP(HP : Int) : Wasp


}

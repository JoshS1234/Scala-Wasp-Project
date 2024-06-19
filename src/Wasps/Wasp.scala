package Wasps

import java.util.UUID

abstract class Wasp(hitpoints : Int) extends CanDie {

  val id : UUID = UUID.randomUUID()
  val damagePerHit : Int
//  var isAlive : Boolean = true

  def getHit : Wasp

  override def die : Unit = println(s"A ${this.getClass.getSimpleName} has died")

  def describe : String = {
    s"${this.getClass.getSimpleName} : ${hitpoints}HP"
  }

  def displayImage : String

  def isAlive : Boolean = {
    if (hitpoints>0) true
    else false
  }

  def getHitpoints : Int = hitpoints

  def setHP(HP : Int) : Wasp


}

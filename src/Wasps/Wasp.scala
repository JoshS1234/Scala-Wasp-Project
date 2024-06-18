import java.util.UUID

abstract class Wasp {

  val id : UUID = UUID.randomUUID()
  var hitpoints : Int
  val damagePerHit : Int
  var isAlive : Boolean = true

  def getHit() : Unit = {
    hitpoints=hitpoints-damagePerHit;
    if (hitpoints<=0) isAlive=false;
  }

  def die : Unit

  def describe : String = {
    s"This ${this.getClass.getSimpleName} has ${hitpoints}HP and takes ${damagePerHit} damage per hit"
  }


}

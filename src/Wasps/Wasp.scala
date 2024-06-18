import java.util.UUID

abstract class Wasp {

  val id : UUID = UUID.randomUUID()
  var hitpoints : Int
  val damagePerHit : Int
  var isAlive : Boolean = true

  def getHit() : Unit = {
    hitpoints=hitpoints-damagePerHit;
    println(s"You hit a ${this.getClass.getSimpleName}, it took ${damagePerHit} damage and it now has ${hitpoints}HP ")
    if (hitpoints<=0) {
      isAlive = false;
      this.die
    }
  }

  def die : Unit

  def describe : String = {
    s"This ${this.getClass.getSimpleName} has ${hitpoints}HP and takes ${damagePerHit} damage per hit"
  }


}

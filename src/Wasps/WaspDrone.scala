package Wasps

class WaspDrone(hitpoints : Int) extends Wasp(hitpoints : Int) {

  override val damagePerHit: Int = 12

  override def getHit : Wasp = {
    println(s"You hit a ${this.getClass.getSimpleName}, it took ${damagePerHit} damage and it now has ${Math.max(hitpoints-damagePerHit,0)}HP ")
    println(displayImage)
    if (hitpoints-damagePerHit <=0) {
      this.die
    }
    new WaspDrone(Math.max(hitpoints-damagePerHit,0))
  }

  override def displayImage: String = {
    "    _  _      \n   | )/ )     \n\\\\ |//,' __   \n(\")(_)-\"()))=-\n   (\\\\        "
  }

  def setHP(HP : Int) : Wasp = {
    new WaspDrone(HP)
  }

  def this() = this(60)

}

class WaspQueen extends Wasp {

  override var hitpoints: Int = 80
  override val damagePerHit: Int = 7

  override def die: Unit = {
    println(s"Unbelievable!!! A ${this.getClass.getSimpleName} has died, so all other wasps die")
  }
}

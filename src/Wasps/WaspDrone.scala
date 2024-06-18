class WaspDrone extends Wasp {

  override var hitpoints: Int = 60
  override val damagePerHit: Int = 12

  override def die: Unit = println(s"A ${this.getClass.getSimpleName} has died")
}

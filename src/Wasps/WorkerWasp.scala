class WorkerWasp extends Wasp {

  override var hitpoints: Int = 68
  override val damagePerHit: Int = 10

  override def die: Unit = println(s"A ${this.getClass.getSimpleName} has died! Keep up the slaughter!")
}

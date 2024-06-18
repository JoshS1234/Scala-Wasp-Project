class WorkerWasp extends Wasp {

  override var hitpoints: Int = 68
  override val damagePerHit: Int = 10

  override def die: Unit = println(s"This worker (ID: ${this.id}) has died")
}

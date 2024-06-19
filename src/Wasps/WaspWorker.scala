package Wasps

class WaspWorker(hitpoints : Int) extends Wasp(hitpoints : Int) {

  override val damagePerHit: Int = 10

  override def getHit : Wasp = {
    println(s"You hit a ${this.getClass.getSimpleName}, it took ${damagePerHit} damage and it now has ${Math.max(hitpoints-damagePerHit,0)}HP ")
    println(displayImage)
    if (hitpoints-damagePerHit <=0) {
      this.die
    }
    new WaspWorker(Math.max(hitpoints-damagePerHit,0))
  }

  override def displayImage: String = {
    "      .-.\n     :   \\                                      ___...__\n      `.  \\      ,                         ,--\"\"        `.\n        `. \\    /       \\               ,\"        ,       \\\n          `.\\  |         )            ,\"      '            )\n            `\\_|,_      /           ,\"     '             ,'\n            ,d####\"\"`-./          ,'    '         _,,--\"\"\n        ,  (### ##  *##b.       ,'   '    __,,--\"\"\n        \\_  V##_,,-. *##:     ,'  __,,--\"\"\n        / ),--\"  __,' *,'--,,'_,-\"\n     ,-(_ :..--'' _,,-'/,    `.\n       ,-( `.'`,-,-,_ //_.    `.\n      ' / \\ .`/ /,/,/\",  \\\\ _. :\n        \\  \\ .`.-/'/ /,   \\\\ \\\\ `.\n            \\ . )\\`'\"\\/    )) \\\\  `.\n             `-\"\\\\\\\\ '`--_//,-.))   `.\n                   \\\\    //   //.    `,\n                         '   // `     `,\n                             '  `.     ',\n                                 :      :\n                                 :      :\n                                 `.     :\n                                  ,    ,'\n                                 ,\"--\"'"
  }

  def setHP(HP : Int) : Wasp = {
    new WaspWorker(HP)
  }

  def this() = this(68)



}

package Wasps

class WaspQueen(hitpoints : Int) extends Wasp(hitpoints : Int) {

  override val damagePerHit: Int = 7

  override def getHit : Wasp = {
    println(s"You hit a ${this.getClass.getSimpleName}, it took ${damagePerHit} damage and it now has ${Math.max(hitpoints-damagePerHit,0)}HP ")
    println(displayImage)
    if (hitpoints-damagePerHit <=0) {
      this.die
    }
    new WaspQueen(Math.max(hitpoints-damagePerHit,0))
  }

  override def die: Unit = {
    println(s"Unbelievable!!! A ${this.getClass.getSimpleName} has died, so all other wasps die")
  }

  override def displayImage: String = {
    "         \" ,  ,\n            \", ,\n               \"\"     _---.    ..;%%%;, .\n                 \"\" .\",  ,  .==% %%%%%%% ' .\n                   \"\", %%%   =%% %%%%%%;  ; ;-_\n                   %; %%%%%  .;%;%%%\"%p ---; _  '-_\n                   %; %%%%% __;%%;p/; O        --_ \"-,_\n                    q; %%% /v \\;%p ;%%%%%;--__    \"'-__'-._\n                    //\\\\\" // \\  % ;%%%%%%%;',/%\\_  __  \"'-_'\\_\n                    \\  / //   \\/   ;%% %; %;/\\%%%%;;;;\\    \"- _\\\n                       ,\"             %;  %%;  %%;;'  ';%       -\\-_\n                  -=\\=\"             __%    %%;_ |;;    %%%\\          \\\n                                  _/ _=      \\==_;;,_ %%%; % -_      /\n                                 / /-          =%- ;%%%%; %%;  \"--__/\n                                //=             ==%-%%;  %; %\n                                /             _=_-  d  ;%; ;%;  :F_P:\n                                \\            =,-\"    d%%; ;%%;\n                                            //        %  ;%%;\n                                           //          d%%%\"\n                                            \\           %%\n                                                        V"
  }

  def setHP(HP : Int) : Wasp = {
    new WaspQueen(HP)
  }



  def this() = this(80)
}

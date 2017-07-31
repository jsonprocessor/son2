package pl.writeonly.son2.main

import pl.writeonly.son2.core.glue.{Core, Params}

class Mainer(params: Params, args: Array[String]) extends Core(params, args, new CreatorProviderOrMain()) {

  override def bad(params: Params, format: String): Unit = new Resourcer(params).bad(format)

}

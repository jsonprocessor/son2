package pl.writeonly.scallions.main

import pl.writeonly.scallions.funs.glue.Core
import pl.writeonly.scallions.funs.glue.{CreatorConverterOr, Params}

class Mainer(params: Params,
             args: Array[String],
             creator: CreatorConverterOr = new CreatorConverterOrMain())
    extends Core(params, args, creator) {

  override def bad(params: Params, format: String): Unit =
    new Resourcer(params).bad(format)

}

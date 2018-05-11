package pl.writeonly.son2.main

import pl.writeonly.son2.funs.glue.{Core, CreatorConverterOr, Params}

class Mainer(params: Params,
             args: Array[String],
             creator: CreatorConverterOr = new CreatorConverterOrMain())
    extends Core(params, args, creator) {

  override def bad(params: Params, format: String): Unit =
    new Resourcer(params).bad(format)

}

package pl.writeonly.scallions.main

import pl.writeonly.scallions.apis.converters.ConverterFake
import pl.writeonly.scallions.funs.glue.{Params, Piper}

class Resourcer(params: Params) {

  def bad(resource: String) =
    new Piper(params, new ConverterFake)
      .convertResource(validOpt(resource))

  def validOpt(resource: String) =
    valid(Option(resource).getOrElse(Resources.README))

  def valid(resource: String) =
    Resources.ALL
      .find(it => it.toLowerCase.startsWith(resource))
      .getOrElse({
        println(Resources.UNKNOWN_FORMAT + resource)
        Resources.README
      })
}

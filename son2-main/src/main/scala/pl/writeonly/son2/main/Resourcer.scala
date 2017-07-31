package pl.writeonly.son2.main

import pl.writeonly.son2.core.glue.{Params, Piper}
import pl.writeonly.son2.core.providers.ProviderFake

class Resourcer(params: Params) {

  def bad(resource: String) = new Piper(params, new ProviderFake)
    .convertResource(validOpt(resource))

  def validOpt(resource: String) = valid(Option(resource).getOrElse(Resources.README))

  def valid(resource: String) = Resources.ALL
    .find(it => it.toLowerCase.startsWith(resource))
    .getOrElse({
      println(Resources.UNKNOWN_FORMAT + resource)
      Resources.README
    })
}

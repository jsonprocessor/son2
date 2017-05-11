package pl.writeonly.son2.main

import pl.writeonly.son2.jack.providers.ProviderFake

class ResourceManager {

  def left(resource: Option[String]) = new Piper(new ProviderFake).convertResource(validOpt(resource))

  def validOpt(resource: Option[String]) = valid(resource.getOrElse(Resources.README))

  def valid(resource: String) = Resources.ALL
    .find(it => it.toLowerCase.startsWith(resource))
    .getOrElse({
      println(Resources.UNKNOWN_FORMAT + resource)
      Resources.README
    })
}
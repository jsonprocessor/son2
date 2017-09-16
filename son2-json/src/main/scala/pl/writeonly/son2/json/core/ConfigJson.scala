package pl.writeonly.son2.json.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.path.core.ProvidersPath

object ConfigJson {
  def apply(s: String): Config = ConfigJson.apply(o = Symbol(s))

  def apply(i: Symbol = ProvidersPath.GSON, s: Boolean = true, o: Symbol, p: Boolean = true) = new Config(
    read = RConfig(format = i, stream = s, path = null), write = WConfig(format = o, style = p)
  )

  def apply(): Config = ConfigJson.apply(ProvidersPath.GSON)

  def apply(s: Symbol): Config = ConfigJson.apply(o = s)

}


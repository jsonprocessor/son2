package pl.writeonly.son2.json.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigJson {
  def apply(s: String): Config = ConfigJson.apply(o = Symbol(s))

  def apply(i: Symbol = ProvidersJson.GSON, s: Boolean = true, o: Symbol, p: Boolean = true) = new Config(
    read = RConfig(format = i, stream = s), write = WConfig(format = o, style = p)
  )

  def apply(): Config = ConfigJson.apply(ProvidersJson.GSON)

  def apply(s: Symbol): Config = ConfigJson.apply(o = s)

}





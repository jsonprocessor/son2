package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigPath {
  def apply(
             q: Option[String] = Option.empty,
             i: Symbol = ProvidersPath.SMART,
             s: Boolean = true,
             o: Symbol = ProvidersPath.SMART,
             p: Boolean = false
           ) = new Config(
    read = RConfig(provider = i, stream = s, path = q),
    write = WConfig(provider = o, style = p)
  )
}



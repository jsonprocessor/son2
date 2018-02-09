package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.{Config, RConfig, RPath, WConfig}

object ConfigPath {
  def apply(provider: Symbol = ProvidersPath.SMART,
            q: Option[String] = Option.empty,
            s: Boolean = true,
            p: Boolean = false) =
    new Config(read = RConfig(provider = provider, stream = s, path = RPath(q)),
               write = WConfig(provider = provider, style = p))
}

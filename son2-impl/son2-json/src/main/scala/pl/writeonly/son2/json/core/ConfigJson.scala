package pl.writeonly.son2.json.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.path.core.ProvidersPath

object ConfigJson {
  def apply(s: String): Config = ConfigJson.apply(provider = Symbol(s))

  def apply(): Config = ConfigJson.apply(ProvidersPath.GSON)

  def apply(s: Symbol): Config = ConfigJson.apply(provider = s)

  def apply(provider: Symbol = ProvidersPath.GSON,
            s: Boolean = true,
            p: Boolean = true) =
    new Config(read = RConfig(provider = provider, stream = s, path = null),
               write = WConfig(provider = provider, style = p))

}

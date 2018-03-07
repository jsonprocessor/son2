package pl.writeonly.son2.json.core

import pl.writeonly.son2.core.config._
import pl.writeonly.son2.path.core.ProvidersPath

object ConfigJson {
  def apply(s: String): Config =
    ConfigJson.apply(provider = Provider(Symbol(s)))

  def apply(): Config = ConfigJson.apply(ProvidersPath.GSON)

  def apply(s: Provider): Config = ConfigJson.apply(provider = s)

  def apply(provider: Provider = ProvidersPath.GSON,
            s: RStyle = RStream,
            p: WStyle = WPretty) =
    Config(read = RConfig(provider = provider, stream = s, path = RPath.parse),
           write = WConfig(provider = provider, style = p))

}

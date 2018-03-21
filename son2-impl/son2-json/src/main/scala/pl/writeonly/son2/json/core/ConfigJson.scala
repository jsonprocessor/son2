package pl.writeonly.son2.json.core

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.path.core.ProvidersPath

object ConfigJson {
  def apply(s: String): RWTConfig =
    ConfigJson.apply(provider = Provider(Symbol(s)))

  def apply(): RWTConfig = ConfigJson.apply(ProvidersPath.GSON)

  def apply(s: Provider): RWTConfig = ConfigJson.apply(provider = s)

  def apply(provider: Provider = ProvidersPath.GSON,
            s: RStyle = RStream,
            p: WStyle = WPretty) =
    RWTConfig(read =
                RConfig(provider = provider, stream = s, path = RPath.parse),
              write = WConfig(provider = provider, style = p))

}

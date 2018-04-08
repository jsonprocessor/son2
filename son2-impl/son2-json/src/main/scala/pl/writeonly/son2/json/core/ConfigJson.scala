package pl.writeonly.son2.json.core

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.core.ConfigCore
import pl.writeonly.son2.path.core.ProvidersPath

import pl.writeonly.son2.apis.core.Formats

object ConfigJson extends ConfigCore {
  def apply(s: String): RWTConfig =
    ConfigJson.apply(provider = ProviderType(Symbol(s)))

  def apply(): RWTConfig = ConfigJson.apply(ProvidersPath.GSON)

  def apply(s: ProviderType): RWTConfig = ConfigJson.apply(provider = s)

  def apply(provider: ProviderType = ProvidersPath.GSON,
            q: RPath = RPath.parse,
            s: RStyle = RStream,
            p: WStyle = WPretty) =
    RWTConfig(
      read = RConfig(
        provider = provider,
        format = Formats.OBJECT,
        stream = s,
        path = q
      ),
      write = WConfig(provider = provider, format = Formats.OBJECT, style = p),
      translate = TConfig(null, Format(""), 0),
      provider = provider
    )

}

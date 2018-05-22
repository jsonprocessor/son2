package pl.writeonly.scallions.json.core

import pl.writeonly.scallions.apis.config.RPath.RPath
import pl.writeonly.scallions.apis.config.RStyle.RStream
import pl.writeonly.scallions.apis.config.WStyle.WPretty
import pl.writeonly.scallions.apis.config.{
  Format,
  ProviderType,
  RPath,
  WStyle,
  _
}
import pl.writeonly.scallions.apis.core.{ConfigCore, Formats}
import pl.writeonly.scallions.path.core.ProvidersPath

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

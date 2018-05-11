package pl.writeonly.scallions.path.core

import pl.writeonly.scallions.apis.config.RPath.RPath
import pl.writeonly.scallions.apis.config.{Format, ProviderType, RPath, WStyle}
import pl.writeonly.scallions.apis.config.RStyle.RStream
import pl.writeonly.scallions.apis.config.WStyle.WRaw
import pl.writeonly.scallions.apis.config._
import pl.writeonly.scallions.apis.core.ConfigCore

object ConfigPath extends ConfigCore {
  def apply(provider: ProviderType = ProvidersPath.SMART,
            q: RPath = RPath.json,
            s: RStyle = RStream,
            p: WStyle = WRaw) =
    RWTConfig(
      read = RConfig(provider = provider, stream = s, path = q),
      write = WConfig(provider = provider, style = p),
      translate = TConfig(action = null, format = Format("")),
      ProvidersPath.JACKSON
    )
}

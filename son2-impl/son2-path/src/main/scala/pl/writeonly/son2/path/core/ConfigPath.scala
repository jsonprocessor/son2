package pl.writeonly.son2.path.core

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.core.ConfigCore

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

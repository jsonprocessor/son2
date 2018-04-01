package pl.writeonly.son2.path.core

import pl.writeonly.son2.apis.config._

object ConfigPath {
  def apply(provider: Provider = ProvidersPath.SMART,
            q: RPath = RPath.json,
            s: RStyle = RStream,
            p: WStyle = WRaw) =
    RWTConfig(
      read = RConfig(provider = provider, stream = s, path = q),
      write = WConfig(provider = provider, style = p)
    )
}

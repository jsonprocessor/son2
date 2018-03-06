package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config._

object ConfigPath {
  def apply(provider: Symbol = ProvidersPath.SMART,
            q: RPath = RPath.json,
            s: RStyle = RStream,
            p: WStyle = WRaw) =
    new Config(read = RConfig(provider = provider, stream = s, path = q),
               write = WConfig(provider = provider, style = p))
}

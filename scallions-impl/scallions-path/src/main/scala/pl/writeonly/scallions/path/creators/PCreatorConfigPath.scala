package pl.writeonly.scallions.path.creators

import pl.writeonly.scalaops.pipe.Pipe._
import pl.writeonly.scallions.apis.chain.PCreatorConfig
import pl.writeonly.scallions.apis.config.WStyle.WRaw
import pl.writeonly.scallions.apis.config.{ProviderType, RPath, _}
import pl.writeonly.scallions.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.scallions.path.core.{ConfigPath, ProvidersPath}

class PCreatorConfigPath(f: ProviderType)
    extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig =
    ConfigPath(provider = ProviderType(Symbol(s)))
}

class PCreatorConfigPathMain extends PCreatorConfig {

  override def isDefinedAt(s: String): Boolean = s && s.startsWith("$")

  override def apply(s: String) =
    RWTConfig(
      read = RConfig(provider = ProvidersPath.SMART, path = RPath(s)),
      write = WConfig(provider = ProvidersPath.STRICT, style = WRaw)
    )
}

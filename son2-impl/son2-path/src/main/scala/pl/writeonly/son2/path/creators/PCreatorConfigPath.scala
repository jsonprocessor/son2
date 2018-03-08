package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config._
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.core.pcreators.PCreatorConfig
import pl.writeonly.son2.path.core.{ConfigPath, ProvidersPath}

class PCreatorConfigPath(f: Provider) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig =
    ConfigPath(provider = Provider(Symbol(s)))
}

class PCreatorConfigPathMain extends PCreatorConfig {

  override def isDefinedAt(s: String) = Option(s).isDefined && s.startsWith("$")

  override def apply(s: String) =
    RWTConfig(read = RConfig(provider = ProvidersPath.SMART, path = RPath(s)),
              write = WConfig(provider = ProvidersPath.STRICT, style = WRaw))
}

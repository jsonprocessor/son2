package pl.writeonly.son2.path.creators

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.apis.pcreators.PCreatorConfig
import pl.writeonly.son2.path.core.{ConfigPath, ProvidersPath}
import pl.writeonly.sons.utils.ops.Pipe._

class PCreatorConfigPath(f: Provider) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig =
    ConfigPath(provider = Provider(Symbol(s)))
}

class PCreatorConfigPathMain extends PCreatorConfig {

  override def isDefinedAt(s: String): Boolean = s && s.startsWith("$")

  override def apply(s: String) =
    RWTConfig(read = RConfig(provider = ProvidersPath.SMART, path = RPath(s)),
              write = WConfig(provider = ProvidersPath.STRICT, style = WRaw))
}

package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.pcreators.PCreatorConfig
import pl.writeonly.son2.path.core.ProvidersPath

class PCreatorConfigPathMain extends PCreatorConfig {

  override def isDefinedAt(s: String) = s != null && s.startsWith("$")

  override def apply(s: String) = new Config(
    read = RConfig(format = Symbol(s), path = Option(s)), write = WConfig(format = ProvidersPath.STRICT, style = false)
  )

}


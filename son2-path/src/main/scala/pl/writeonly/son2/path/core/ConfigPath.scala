package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigPath {
  def apply(
             q: Option[String] = Option.empty,
             i: Symbol = FormatsPath.SMART,
             s: Boolean = true,
             o: Symbol = FormatsPath.SMART,
             p: Boolean = false
           ) = new Config(
    read = RConfig(format = i, stream = s, query = q),
    write = WConfig(format = o, style = p)
  )
}



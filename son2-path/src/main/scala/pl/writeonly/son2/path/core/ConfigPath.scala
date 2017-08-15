package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigPath {
  def apply(
             i: Symbol = Symbol("$"),
             s: Boolean = true,
             o: Symbol = Formats.SMART,
             p: Boolean = false
           ) = new Config(
    read = RConfig(format= i, stream=s, query = Option(i.name)),
    write = WConfig(format = o, style = p)
  )
}



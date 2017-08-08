package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.{Config, RConfig}

object ConfigPath {
  def apply(
             i: Symbol = Symbol("$"),
             s: Boolean = true,
             o: Symbol = Formats.SMART,
             p: Boolean = false
           ) = new Config(read = RConfig(i, s), writeFormat= o, writeStyle= p)
}



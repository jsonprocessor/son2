package pl.writeonly.son2.json.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigGson {
  def apply(s: String): Config = ConfigGson.apply(o = Symbol(s))

  def apply(): Config = ConfigGson.apply(FormatsGson.GSON)

  def apply(s: Symbol): Config = ConfigGson.apply(o = s)

  def apply(i: Symbol = FormatsGson.GSON, s: Boolean = true, o: Symbol, p: Boolean = true) = new Config(
    read = RConfig(format = i, stream = s), write = WConfig(format = o, style = p)
  )

}





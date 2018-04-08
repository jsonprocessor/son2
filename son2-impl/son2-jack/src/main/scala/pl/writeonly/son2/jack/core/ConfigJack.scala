package pl.writeonly.son2.jack.core

import pl.writeonly.son2.apis.config._

object ConfigJack {
  def apply(s: String): RWTConfig = ConfigJack.apply(o = Format(s))

  def apply(i: Format = FormatsJack.OBJECT,
            s: RStyle = RStream,
            o: Format,
            p: WStyle = WPretty) =
    RWTConfig(
      read = RConfig(provider = Provider('jackson), format = i, stream = s),
      write = WConfig(provider = Provider('jackson), format = o, style = p),
      TConfig(null, Format(""), 0),
      provider = Provider('jackson)
    )

  def apply(): RWTConfig = ConfigJack.apply(FormatsJack.YAML)

  def apply(s: Format): RWTConfig = ConfigJack.apply(o = s)

}

package pl.writeonly.scallions.jack.core

import pl.writeonly.scallions.apis.config.{Format, WStyle}
import pl.writeonly.scallions.apis.config.RStyle.RStream
import pl.writeonly.scallions.apis.config.WStyle.WPretty
import pl.writeonly.scallions.apis.config._
import pl.writeonly.scallions.apis.core.ConfigCore

object ConfigJack extends ConfigCore {
  def apply(s: String): RWTConfig = ConfigJack.apply(o = Format(s))

  def apply(i: Format = FormatsJack.OBJECT,
            s: RStyle = RStream,
            o: Format,
            p: WStyle = WPretty) =
    RWTConfig(
      read = RConfig(provider = ProvidersJack.JACKSON, format = i, stream = s),
      write = WConfig(provider = ProvidersJack.JACKSON, format = o, style = p),
      TConfig(null, Format(""), 0),
      provider = ProvidersJack.JACKSON
    )

  def apply(): RWTConfig = ConfigJack.apply(FormatsJack.YAML)

  def apply(s: Format): RWTConfig = ConfigJack.apply(o = s)

}

package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.notation.PartialCreator
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.NotationReaderPath

class PartialCreatorPath extends PartialCreator {

  override def isDefinedAt(s: String) = s != null && s.startsWith("$")

  override def c: (String) => Config = s => new Config(
    read = RConfig(format = Symbol(s), query = Option(s)), write = WConfig(format = Formats.STRICT, style = false)
  )

  override def r(c: Config) = new NotationReaderPath(c.read.query.get)

}

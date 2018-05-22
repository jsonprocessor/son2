package pl.writeonly.scallions.apis.converters

import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.notation.{NotationReaderLike, NotationWriter}

class Converter2(override val config: RWTConfig,
                 val in: NotationReaderLike,
                 val out: NotationWriter)
    extends Converter(config) {

  def convert(content: String): String = out.write(in.apply(content))

  def comment(content: String): String = out.comment(content)

  override def toString: String = (getClass, config, in.meta, out.meta).toString

  override def metas = (in.meta, out.meta)
}

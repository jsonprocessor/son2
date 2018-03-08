package pl.writeonly.son2.core.converters

import com.google.common.base.MoreObjects
import pl.writeonly.son2.core.config.RWTConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class Converter2(config: RWTConfig,
                 val in: NotationReader,
                 val out: NotationWriter)
    extends Converter(config) {

  def convert(content: String): String = out.write(in.apply(content))

  def comment(content: String): String = out.comment(content)

  override def toString: String =
    MoreObjects
      .toStringHelper(this)
      .addValue(config)
      .addValue(in)
      .addValue(out)
      .toString

}

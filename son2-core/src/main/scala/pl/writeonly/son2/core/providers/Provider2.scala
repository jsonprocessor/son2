package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class Provider2(config: Config, val in: NotationReader, val out: NotationWriter)
  extends Provider(config) {

  def convert(content: String): String = out.write(in.apply(content))

  def comment(content: String): String = out.comment(content)

}

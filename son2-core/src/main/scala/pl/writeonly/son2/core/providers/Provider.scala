package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.glue.Config
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class Provider(val config:Config, val in: NotationReader, val out: NotationWriter) {

  def apply(content: String): String = out.write(in.apply(content))

  def convert(s: String) = apply(s)

  def comment(content: String): String = out.comment(content)

}

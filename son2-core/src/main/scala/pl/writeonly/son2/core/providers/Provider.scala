package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.notation.{Config, NotationReader, NotationWriter}

class Provider(val config: Config, val in: NotationReader, val out: NotationWriter) {

  def convert(s: String) = apply(s)

  def apply(content: String): String = out.write(in.apply(content))

  def comment(content: String): String = out.comment(content)

}

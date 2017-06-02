package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class Converter(val in: NotationReader, val out: NotationWriter) {

  def apply(content: String): String = out.write(in.apply(content))

  def comment(content: String): String = out.comment(content)

}

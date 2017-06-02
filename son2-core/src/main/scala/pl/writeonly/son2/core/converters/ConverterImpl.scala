package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class ConverterImpl(val in: NotationReader, val out: NotationWriter) extends Converter {

  def apply(content: String): String = out.write(in.readTree(content))

}

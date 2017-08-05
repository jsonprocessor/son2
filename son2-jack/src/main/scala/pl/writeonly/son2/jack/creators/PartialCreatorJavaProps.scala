package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJavaProps, NotationWriterJack}

class PartialCreatorJavaProps(pretty: Boolean) extends PartialCreatorJack {
  def format = Formats.JAVA_PROPS

  override def r(s: String) = new NotationReaderJavaProps

  override def w(s: String) = new NotationWriterJack(pretty, new JavaPropsMapper, "#", "")
}

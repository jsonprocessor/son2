package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationReaderJavaProps, NotationWriterJack}

class PartialCreatorJavaProps(pretty: Boolean) extends PartialCreatorPair {
  def startsWith = Formats.JAVA_PROPS

  def r = new NotationReaderJavaProps

  def w = new NotationWriterJack(pretty, new JavaPropsMapper, "#", "")
}

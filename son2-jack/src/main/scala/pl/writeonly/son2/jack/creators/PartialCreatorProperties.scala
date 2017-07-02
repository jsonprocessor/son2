package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class PartialCreatorProperties(pretty: Boolean) extends PartialCreatorJavaProps(pretty) {
  override def startsWith = Formats.PROPERTIES
}

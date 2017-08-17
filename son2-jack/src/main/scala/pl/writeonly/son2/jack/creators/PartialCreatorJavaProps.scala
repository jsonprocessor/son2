package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderJavaProps, NotationWriterJack}

class PartialCreatorJavaProps(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.JAVA_PROPS

  override def r(c: Config) = new NotationReaderJavaProps

  override def w(c: Config) = new NotationWriterJack(c.write, pretty, new JavaPropsMapper, "#", "")
}

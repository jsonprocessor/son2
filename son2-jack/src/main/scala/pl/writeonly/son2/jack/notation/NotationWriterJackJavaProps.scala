package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper

class NotationWriterJackJavaProps(val pretty: Boolean)
  extends NotationWriterJack(pretty, new JavaPropsMapper()) {

  override def comment(s: String) = "#" + s
}

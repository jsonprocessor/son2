package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.jack.core.FormatsJack

class PartialCreatorProperties(pretty: Boolean) extends PartialCreatorJavaProps(pretty) {
  override def format = FormatsJack.PROPERTIES
}

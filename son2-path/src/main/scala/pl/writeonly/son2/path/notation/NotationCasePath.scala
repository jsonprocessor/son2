package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json._
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath

abstract class NotationCasePath(
                     val format: Symbol,
                     val reader: NotationReader,
                     val writer: WConfig => NotationWriter,
                     val provider : JsonProvider
)


case class NotationCaseNode()
  extends NotationCasePath(FormatsPath.JACKSON_NODE, null, null, new JacksonJsonNodeJsonProvider())

case class NotationCaseJackson()
  extends NotationCasePath(FormatsPath.JACKSON, null, null, new JacksonJsonProvider())





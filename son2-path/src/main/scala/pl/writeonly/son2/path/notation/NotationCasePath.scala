package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath

abstract class NotationCasePath(
                     val format: Symbol,
                     val reader: NotationReader,
                     val writer: WConfig => NotationWriter,
                     val provider : JsonProvider,
                     val mapper : MappingProvider
)


case class NotationCaseNode()
  extends NotationCasePath(FormatsPath.JACKSON_NODE, null, null, new JacksonJsonNodeJsonProvider(), new JacksonMappingProvider())

case class NotationCaseJackson()
  extends NotationCasePath(FormatsPath.JACKSON, null, null, new JacksonJsonProvider(), new JacksonMappingProvider())





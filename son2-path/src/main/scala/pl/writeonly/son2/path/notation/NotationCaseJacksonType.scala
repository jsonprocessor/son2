package pl.writeonly.son2.path.notation

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.{Gson, GsonBuilder}
import com.jayway.jsonpath.spi.json.{JacksonJsonNodeJsonProvider, JacksonJsonProvider}
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.notation.NotationWriterJack
import pl.writeonly.son2.path.core.{DefaultsPath, FormatsPath}


case class NotationCaseJacksonType()
  extends NotationCasePath(FormatsPath.JACKSON_TYPE,
    c => new NotationReaderJackson(c),
      c => new NotationWriterJack(c, JackObject()))


case class NotationCaseJacksonNode()
  extends NotationCasePath(FormatsPath.JACKSON_NODE,
    c => new NotationReaderJackson(c),
    c => new NotationWriterJack(c, JackObject()))

class NotationReaderJackson(c: RConfig)
  extends NotationReaderPath(new DefaultsJacksonNode(c))


class DefaultsJacksonNode(c: RConfig, objectMapper: ObjectMapper)
  extends DefaultsPath(c, new JacksonJsonNodeJsonProvider(objectMapper), new JacksonMappingProvider(objectMapper)) {
  def this(c: RConfig) = this(c, new ObjectMapper())
}

class DefaultsJacksonType(c: RConfig, objectMapper: ObjectMapper)
  extends DefaultsPath(c, new JacksonJsonProvider(objectMapper), new JacksonMappingProvider(objectMapper)) {
  def this(c: RConfig) = this(c, new ObjectMapper())
}


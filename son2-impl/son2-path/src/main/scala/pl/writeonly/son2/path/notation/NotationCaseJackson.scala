package pl.writeonly.son2.path.notation

import com.fasterxml.jackson.databind.{ObjectMapper, ObjectReader}
import com.jayway.jsonpath.spi.json.{
  JacksonJsonNodeJsonProvider,
  JacksonJsonProvider
}
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.notation.NotationWriterJack
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseJackson()
    extends NotationCasePath(ProvidersPath.JACKSON,
                             c => new NotationReaderJackson(c),
                             c => new NotationWriterJack(c, JackObject()))

case class NotationCaseJacksonType()
    extends NotationCasePath(ProvidersPath.JACKSON_TYPED,
                             c => new NotationReaderJackson(c),
                             c => new NotationWriterJack(c, JackObject()))

class NotationReaderJackson(c: RConfig)
    extends NotationReaderPath(new DefaultsJackson(c))

class DefaultsJackson(c: RConfig, objectMapper: ObjectMapper)
    extends DefaultsPath(c,
                         new JacksonJsonNodeJsonProvider(objectMapper),
                         new JacksonMappingProvider(objectMapper)) {
  def this(c: RConfig) = this(c, new ObjectMapper())
}

class DefaultsJacksonTyped(c: RConfig,
                           mapper: ObjectMapper,
                           reader: ObjectReader)
    extends DefaultsPath(c,
                         new JacksonJsonProvider(mapper, reader),
                         new JacksonMappingProvider(mapper)) {
  def this(c: RConfig, mapper: ObjectMapper) =
    this(c, mapper, mapper.reader.withType(classOf[Any]))

  def this(c: RConfig) = this(c, new ObjectMapper())
}

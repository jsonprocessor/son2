package pl.writeonly.son2.path.notation

import com.fasterxml.jackson.databind.{ObjectMapper, ObjectReader}
import com.jayway.jsonpath.spi.json.{
  JacksonJsonNodeJsonProvider,
  JacksonJsonProvider
}
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import pl.writeonly.son2.apis.config.{Meta, MetaImpl, RConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.jack.core.{Jack, JackImpl, JackObject}
import pl.writeonly.son2.jack.notation.NotationWriterJack
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseJackson() extends NotationCaseJacksonLike(JackObject())

case class NotationCaseJacksonType()
    extends NotationCaseJacksonLike(
      JackImpl(NotationCaseJacksonType.meta, new ObjectMapper, "", "")
    )

object NotationCaseJacksonType {
  val meta = MetaImpl(ProvidersPath.JACKSON_TYPED, Formats.OBJECT)
}

abstract class NotationCaseJacksonLike(jack: Jack)
    extends NotationCasePath(
      jack.meta,
      c => new NotationReaderJackson(jack.meta, c),
      c => new NotationWriterJack(jack, c)
    )

class NotationReaderJackson(meta: Meta, c: RConfig)
    extends NotationReaderPath(meta, new DefaultsJackson(c))

class DefaultsJackson(c: RConfig, objectMapper: ObjectMapper)
    extends DefaultsPath(
      c,
      new JacksonJsonNodeJsonProvider(objectMapper),
      new JacksonMappingProvider(objectMapper)
    ) {
  def this(c: RConfig) = this(c, new ObjectMapper())
}

class DefaultsJacksonTyped(c: RConfig,
                           mapper: ObjectMapper,
                           reader: ObjectReader)
    extends DefaultsPath(
      c,
      new JacksonJsonProvider(mapper, reader),
      new JacksonMappingProvider(mapper)
    ) {
  def this(c: RConfig, mapper: ObjectMapper) =
    this(c, mapper, mapper.reader.withType(classOf[Any]))

  def this(c: RConfig) = this(c, new ObjectMapper())
}

package pl.writeonly.scallions.path.notations

import com.fasterxml.jackson.databind.{ObjectMapper, ObjectReader}
import com.jayway.jsonpath.spi.json.{JacksonJsonNodeJsonProvider, JacksonJsonProvider}
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.{CreatorNotation, NotationReaderPath}
import pl.writeonly.scallions.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.jack.core.{Jack, JackImpl, JackObject}
import pl.writeonly.scallions.jack.notation.NotationWriterJack
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.{CreatorNotation, NotationReaderPath}

trait CreatorNotationJacksonLike extends CreatorNotation {

  override def reader(c: RConfig) =
    new NotationReaderPath(meta, defaultsPath(c))

  override def writer(c: WConfig) = new NotationWriterJack(jack, c)

  def jack: Jack

  def mapper: ObjectMapper = jack.mapper

  def meta: Meta = jack.meta

}

object CreatorNotationJackson extends CreatorNotationJacksonLike {

  val jack = JackObject()

  override def jsonProvider = new JacksonJsonNodeJsonProvider(mapper)

  override def mappingProvider = new JacksonMappingProvider(mapper)
}

object CreatorNotationJacksonTyped extends CreatorNotationJacksonLike {

  //  val jack = JackObject().copy(meta = Meta(ProvidersPath.JACKSON_TYPED, Formats.OBJECT))
  val jack = JackImpl(
    Meta(ProvidersPath.JACKSON_TYPED, Formats.OBJECT),
    new ObjectMapper,
    "",
    ""
  )

  val reader: ObjectReader = mapper.reader.withType(classOf[Any])

  override def jsonProvider = new JacksonJsonProvider(mapper, reader)

  override def mappingProvider = new JacksonMappingProvider(mapper)
}

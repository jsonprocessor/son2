package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.apis.notation.NotationReaderLike
import pl.writeonly.son2.jack.core._

class NotationReaderJack(val meta: MetaJack) extends NotationReaderLike {
  def apply(content: String): JsonNode = meta.mapper.readTree(content)
}

class NotationReaderObject extends NotationReaderJack(MetaJackObject())

class NotationReaderXml extends NotationReaderJack(MetaJackXml())

class NotationReaderYaml extends NotationReaderJack(MetaJackYaml())

class NotationReaderCsv extends NotationReaderJack(MetaJackCsv())

class NotationReaderJavaProps extends NotationReaderJack(MetaJackJavaProps())

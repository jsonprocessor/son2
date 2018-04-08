package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.apis.notation.NotationReaderLike
import pl.writeonly.son2.jack.core._

class NotationReaderJack(val meta: Jack) extends NotationReaderLike {
  def apply(content: String): JsonNode = meta.mapper.readTree(content)
}

class NotationReaderObject extends NotationReaderJack(JackObject())

class NotationReaderXml extends NotationReaderJack(JackXml())

class NotationReaderYaml extends NotationReaderJack(JackYaml())

class NotationReaderCsv extends NotationReaderJack(JackCsv())

class NotationReaderJavaProps extends NotationReaderJack(JackJavaProps())

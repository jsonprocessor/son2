package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.apis.notation.NotationReader
import pl.writeonly.son2.jack.core._

class NotationReaderJack(val jack: Jack) extends NotationReader(jack.meta) {
  override def apply(content: String): JsonNode = jack.mapper.readTree(content)
}

case class NotationReaderObject() extends NotationReaderJack(JackObject())

case class NotationReaderXml() extends NotationReaderJack(JackXml())

case class NotationReaderYaml() extends NotationReaderJack(JackYaml())

case class NotationReaderCsv() extends NotationReaderJack(JackCsv())

case class NotationReaderJavaProps() extends NotationReaderJack(JackJavaProps())

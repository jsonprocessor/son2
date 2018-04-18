package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.apis.notation.NotationReader
import pl.writeonly.son2.jack.core._

class NotationReaderJack(val jack: Jack) extends NotationReader(jack.meta) {
  override def apply(content: String): JsonNode = jack.mapper.readTree(content)
}

final case class NotationReaderObject() extends NotationReaderJack(JackObject())

final case class NotationReaderXml() extends NotationReaderJack(JackXml())

final case class NotationReaderYaml() extends NotationReaderJack(JackYaml())

final case class NotationReaderCsv() extends NotationReaderJack(JackCsv())

final case class NotationReaderJavaProps()
    extends NotationReaderJack(JackJavaProps())

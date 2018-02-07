package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.{ JsonNode, ObjectMapper }
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderJack(val mapper: ObjectMapper) extends NotationReader {
  def apply(content: String): JsonNode = mapper.readTree(content)
}

class NotationReaderObject extends NotationReaderJack(new ObjectMapper)

class NotationReaderXml extends NotationReaderJack(new XmlMapper)

class NotationReaderYaml extends NotationReaderJack(new YAMLMapper)

class NotationReaderCsv extends NotationReaderJack(new CsvMapper)

class NotationReaderJavaProps extends NotationReaderJack(new JavaPropsMapper)

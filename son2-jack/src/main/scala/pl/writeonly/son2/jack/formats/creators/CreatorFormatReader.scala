package pl.writeonly.son2.jack.formats.creators

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.jack.notation.NotationReaderJack

class CreatorFormatReader extends CreatorFormat[NotationReaderJack] {

  override def on: NotationReaderJack = new NotationReaderJack(new ObjectMapper)

  override def yaml: NotationReaderJack = new NotationReaderJack(new YAMLMapper)

  override def xml: NotationReaderJack = new NotationReaderJack(new XmlMapper)

  override def csv: NotationReaderJack = new NotationReaderJack(new CsvMapper)

  override def javaprops: NotationReaderJack = new NotationReaderJack(new JavaPropsMapper)
}


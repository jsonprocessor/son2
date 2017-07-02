package pl.writeonly.son2.jack.formats.creators

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.glue.Config
import pl.writeonly.son2.jack.notation.NotationWriterJack

class CreatorFormatWriter(config: Config) extends CreatorFormat[NotationWriterJack] {

  override def on: NotationWriterJack = new NotationWriterJack(pretty, new ObjectMapper(), "#", "")

  override def yaml: NotationWriterJack = new NotationWriterJack(pretty, new YAMLMapper(), "#", "")

  def pretty = config.p

  override def xml: NotationWriterJack = new NotationWriterJack(pretty, new XmlMapper(), "<!-- ", " -->")

  override def csv: NotationWriterJack = new NotationWriterJack(pretty, new CsvMapper(), "#", "")

  override def javaprops: NotationWriterJack = new NotationWriterJack(pretty, new JavaPropsMapper(), "#", "")

}


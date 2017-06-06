package pl.writeonly.son2.jack.formats.creators

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.glue.Config
import pl.writeonly.son2.core.glue.Config
import pl.writeonly.son2.jack.notation.{NotationWriterJack, _}

class CreatorFormatWriter(config: Config) extends CreatorFormat[NotationWriterJack] {

  override def on: NotationWriterJack = new NotationWriterJack(pretty, new ObjectMapper(), "#", "")

  override def yaml: NotationWriterJack = new NotationWriterJack(pretty, new YAMLMapper(), "#", "")

  override def xml: NotationWriterJack = new NotationWriterJack(pretty, new XmlMapper(), "<!-- ", " -->")

  override def csv: NotationWriterJack = new NotationWriterJack(pretty, new CsvMapper(), "#", "")

  override def javaprops: NotationWriterJack = new NotationWriterJack(pretty, new JavaPropsMapper(), "#", "")

  def pretty = config.p

}


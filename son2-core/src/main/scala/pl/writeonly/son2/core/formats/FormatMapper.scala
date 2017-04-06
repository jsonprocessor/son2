package pl.writeonly.son2.core.formats

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper

class FormatMapper extends Format[ObjectMapper] {

  override def on(): ObjectMapper = new ObjectMapper

  override def yaml(): ObjectMapper = new YAMLMapper

  override def xml(): ObjectMapper = new XmlMapper

  override def csv(): ObjectMapper = new CsvMapper

  override def javaprops(): ObjectMapper = new JavaPropsMapper
}

object FormatMapper {
  def apply(config:Config):ObjectMapper = apply(config.i)

  def apply(i:String):ObjectMapper = new FormatMapper().apply(i).get
}
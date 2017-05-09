package pl.writeonly.son2.jack.formats.creators

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper

class CreatorFormatMapper extends CreatorFormat[ObjectMapper] {

  override def on: ObjectMapper = new ObjectMapper

  override def yaml: ObjectMapper = new YAMLMapper

  override def xml: ObjectMapper = new XmlMapper

  override def csv: ObjectMapper = new CsvMapper

  override def javaprops: ObjectMapper = new JavaPropsMapper
}


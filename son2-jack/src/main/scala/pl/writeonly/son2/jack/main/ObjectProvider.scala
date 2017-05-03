package pl.writeonly.son2.jack.main

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.formats.Format

import scala.util.control.Exception.catching

class ObjectFormat() extends Format[ObjectMapper] {

  override def apply(s:String) : Either[Option[String],ObjectMapper] = s match {
    case s if isDefined(s, on) => Right(on)
    case s if isDefined(s, yaml) => Right(yaml)
    case s if isDefined(s, xml) => Right(xml)
    case s if isDefined(s, csv) => Right(csv)
    case s if isDefined(s, javaprops) => Right(javaprops)
    case l => Left(Option(l))
  }

  def isDefined(s : String, om : ObjectMapper) : Boolean = catching(classOf[Exception])
    .opt(om.readTree(s))
    .isDefined

  override def on(): ObjectMapper = new ObjectMapper

  override def yaml(): ObjectMapper = new YAMLMapper

  override def xml(): ObjectMapper = new XmlMapper

  override def csv(): ObjectMapper = new CsvMapper

  override def javaprops(): ObjectMapper = new JavaPropsMapper
}


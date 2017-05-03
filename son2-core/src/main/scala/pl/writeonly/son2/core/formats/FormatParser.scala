package pl.writeonly.son2.core.formats

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}

import scala.util.control.Exception.catching

class FormatParser extends FormatMapper {

  def parse(s:String) : JsonNode = apply(s)
    .right
    .get
    .readTree(s)

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

}


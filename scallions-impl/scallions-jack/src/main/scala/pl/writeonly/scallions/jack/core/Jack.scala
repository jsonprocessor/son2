package pl.writeonly.scallions.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.scallions.apis.config.{Format, Meta}

object Jack {
  def meta(format: Format) = Meta(ProvidersJack.JACKSON, format)
}

sealed abstract class Jack(val meta: Meta,
                           val mapper: ObjectMapper,
                           val s1: String,
                           val s2: String) {
  def this(format: Format, mapper: ObjectMapper, s1: String, s2: String) =
    this(Jack.meta(format), mapper, s1, s2)
}

final case class JackImpl(override val meta: Meta,
                          override val mapper: ObjectMapper,
                          override val s1: String,
                          override val s2: String)
    extends Jack(meta, mapper, s1, s2)

final case class JackObject()
    extends Jack(FormatsJack.OBJECT, new ObjectMapper, "", "")

final case class JackXml()
    extends Jack(FormatsJack.XML, new XmlMapper, "<!-- ", " -->")

final case class JackYaml()
    extends Jack(FormatsJack.YAML, new YAMLMapper, "#", "")

final case class JackCsv() extends Jack(FormatsJack.CSV, new CsvMapper, "", "")

final case class JackProperties()
    extends Jack(FormatsJack.PROPERTIES, new JavaPropsMapper, "#", "")

final case class JackJavaProps()
    extends Jack(FormatsJack.JAVA_PROPS, new JavaPropsMapper, "#", "")

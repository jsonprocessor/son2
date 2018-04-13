package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.apis.config.{Format, Meta, MetaImpl}

object Jack {
  def meta(format: Format) = MetaImpl(ProvidersJack.JACKSON, format)
}

sealed abstract class Jack(val meta: Meta,
                           val mapper: ObjectMapper,
                           val s1: String,
                           val s2: String) {
  def this(format: Format, mapper: ObjectMapper, s1: String, s2: String) =
    this(Jack.meta(format), mapper, s1, s2)
}

case class JackImpl(override val meta: Meta,
                    override val mapper: ObjectMapper,
                    override val s1: String,
                    override val s2: String)
    extends Jack(meta, mapper, s1, s2)

case class JackObject()
    extends Jack(FormatsJack.OBJECT, new ObjectMapper, "", "")

case class JackXml()
    extends Jack(FormatsJack.XML, new XmlMapper, "<!-- ", " -->")

case class JackYaml() extends Jack(FormatsJack.YAML, new YAMLMapper, "#", "")

case class JackCsv() extends Jack(FormatsJack.CSV, new CsvMapper, "", "")

case class JackProperties()
    extends Jack(FormatsJack.PROPERTIES, new JavaPropsMapper, "#", "")

case class JackJavaProps()
    extends Jack(FormatsJack.JAVA_PROPS, new JavaPropsMapper, "#", "")

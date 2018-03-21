package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.apis.config.Format

abstract class Jack(val format: Format,
                    val mapper: ObjectMapper,
                    val s1: String,
                    val s2: String)

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

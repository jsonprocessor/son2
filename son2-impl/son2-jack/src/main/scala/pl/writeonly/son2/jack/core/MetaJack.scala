package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.apis.config.{Format, Meta}

abstract class MetaJack(format: Format,
                        val mapper: ObjectMapper,
                        val s1: String,
                        val s2: String)
    extends Meta(ProvidersJack.JACKSON, format)

case class MetaJackObject()
    extends MetaJack(FormatsJack.OBJECT, new ObjectMapper, "", "")

case class MetaJackXml()
    extends MetaJack(FormatsJack.XML, new XmlMapper, "<!-- ", " -->")

case class MetaJackYaml()
    extends MetaJack(FormatsJack.YAML, new YAMLMapper, "#", "")

case class MetaJackCsv()
    extends MetaJack(FormatsJack.CSV, new CsvMapper, "", "")

case class MetaJackProperties()
    extends MetaJack(FormatsJack.PROPERTIES, new JavaPropsMapper, "#", "")

case class MetaJackJavaProps()
    extends MetaJack(FormatsJack.JAVA_PROPS, new JavaPropsMapper, "#", "")

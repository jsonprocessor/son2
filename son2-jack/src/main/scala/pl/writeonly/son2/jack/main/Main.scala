package pl.writeonly.son2.jack.main

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.util.AppLogging

import pl.writeonly.son2.core.Formats._


object Main extends AppLogging {
  def mapper(arg:String) : Option[ObjectMapper]  = arg match {
    case o if (OBJECT.startsWith(o)) => Option(new ObjectMapper)
    case y if (YAML.startsWith(y)) => Option(new YAMLMapper)
    case x if (XML.startsWith(x)) => Option(new XmlMapper)
    case c if (CSV.startsWith(c)) => Option(new CsvMapper)
    case j if (JAVA_PROPS.startsWith(j)) => Option(new JavaPropsMapper)
    case p if (PROPERTIES.startsWith(p)) => Option(new JavaPropsMapper)
    case _ => Option.empty
  }

  val self = this

}

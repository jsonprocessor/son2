package pl.writeonly.son2.jack.main

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.util.AppLogging


object Main extends AppLogging {
  def mapper(arg:String) : Option[ObjectMapper]  = arg match {
    case o if ("object".startsWith(o)) => Option(new ObjectMapper)
    case y if ("yaml".startsWith(y)) => Option(new YAMLMapper)
    case x if ("xml".startsWith(x)) => Option(new XmlMapper)
    case c if ("csv".startsWith(c)) => Option(new CsvMapper)
    case j if ("javaprops".startsWith(j)) => Option(new JavaPropsMapper)
    case p if ("properties".startsWith(p)) => Option(new JavaPropsMapper)
    case _ => Option.empty
  }






}

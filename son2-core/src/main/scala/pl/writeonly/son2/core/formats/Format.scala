package pl.writeonly.son2.core.formats

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.formats.Formats._

trait Format[F] {
  def apply(arg : String) :Option[F] = arg match {
    case o if (OBJECT.startsWith(o)) => Option(apply())
    case y if (YAML.startsWith(y)) => Option(yaml())
    case x if (XML.startsWith(x)) => Option(xml())
    case c if (CSV.startsWith(c)) => Option(csv())
    case j if (JAVA_PROPS.startsWith(j)) => Option(javaprops())
    case p if (PROPERTIES.startsWith(p)) => Option(javaprops())
    case _ => Option.empty
  }

  def apply() : F
  def yaml() : F
  def xml() : F
  def csv() : F
  def javaprops() : F
}

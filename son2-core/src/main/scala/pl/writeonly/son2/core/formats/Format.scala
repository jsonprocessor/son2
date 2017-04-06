package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Formats._

trait Format[F] {
  def apply(arg: String): Option[F] = arg match {
    case o if (OBJECT.startsWith(o)) => Option(on())
    case y if (YAML.startsWith(y)) => Option(yaml())
    case x if (XML.startsWith(x)) => Option(xml())
    case c if (CSV.startsWith(c)) => Option(csv())
    case j if (JAVA_PROPS.startsWith(j)) => Option(javaprops())
    case p if (PROPERTIES.startsWith(p)) => Option(javaprops())
    case _ => Option.empty
  }

  def on(): F

  def yaml(): F

  def xml(): F

  def csv(): F

  def javaprops(): F
}

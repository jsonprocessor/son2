package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Formats._

trait Format[F] {
  def apply(arg: String): Either[Option[String], F] = arg match {
    case o if (OBJECT.startsWith(o)) => Right(on())
    case y if (YAML.startsWith(y)) => Right(yaml())
    case x if (XML.startsWith(x)) => Right(xml())
    case c if (CSV.startsWith(c)) => Right(csv())
    case j if (JAVA_PROPS.startsWith(j)) => Right(javaprops())
    case p if (PROPERTIES.startsWith(p)) => Right(javaprops())
    case l => Left(Option(l))
  }

  def on(): F

  def yaml(): F

  def xml(): F

  def csv(): F

  def javaprops(): F
}

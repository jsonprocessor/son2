package pl.writeonly.son2.jack.formats.predicates

import pl.writeonly.son2.jack.core.Formats._
import pl.writeonly.son2.jack.formats.creators.CreatorFormat

class PredicateFormatStartsWith[F]() extends PredicateFormat[F]() {

  override def on(s: String): Boolean = OBJECT.name.startsWith(s)

  override def yaml(s: String): Boolean = YAML.name.startsWith(s)

  override def xml(s: String): Boolean = XML.name.startsWith(s)

  override def csv(s: String): Boolean = CSV.name.startsWith(s)

  override def javaprops(s: String): Boolean = JAVA_PROPS.name.startsWith(s)

  override def properties(s: String): Boolean = PROPERTIES.name.startsWith(s)

}

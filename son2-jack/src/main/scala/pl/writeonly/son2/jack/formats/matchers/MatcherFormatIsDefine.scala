package pl.writeonly.son2.jack.formats.matchers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.formats.creators.CreatorFormat

import scala.util.control.Exception.catching

class MatcherFormatIsDefine(c: CreatorFormat[ObjectMapper]) extends MatcherFormat[ObjectMapper](c) {

  override def on(s: String): Boolean = isDefined(s, c.on)

  override def yaml(s: String): Boolean = isDefined(s, c.yaml)

  override def xml(s: String): Boolean = isDefined(s, c.xml)

  override def csv(s: String): Boolean = isDefined(s, c.csv)

  override def javaprops(s: String): Boolean = isDefined(s, c.javaprops)

  override def properties(s: String): Boolean = isDefined(s, c.javaprops)

  def isDefined(s: String, om: ObjectMapper): Boolean = catching(classOf[Exception])
    .opt(om.readTree(s))
    .isDefined

}

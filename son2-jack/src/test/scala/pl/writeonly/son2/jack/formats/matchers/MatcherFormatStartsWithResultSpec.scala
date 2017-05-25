package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.spec.WhiteResultSpec


class MatcherFormatStartsWithResultSpec extends WhiteResultSpec {
  val matcher = new MatcherFormatStartsWith(mock[CreatorFormat[Unit]])
  "A Matcher" when {
    "param is empty object json" should {
      "return true" in {
        assertResult(true) { matcher.on(Formats.OBJECT.substring(0, 1))}
      }
    }
    "param is empty yaml" should {
      "return true" in {
        assertResult(true) { matcher.yaml(Formats.YAML.substring(0, 1))}
      }
    }
    "param is empty xml" should {
      "return true" in {
        assertResult(true) { matcher.xml(Formats.XML.substring(0, 1))}
      }
    }
    "param is empty csv" should {
      "return true" in {
        assertResult(true) { matcher.csv(Formats.CSV.substring(0, 1))}
      }
    }
    "param is empty javaprops" should {
      "return true" in {
        assertResult(true) { matcher.javaprops(Formats.JAVA_PROPS.substring(0, 1))}
      }
    }
    "param is empty properties" should {
      "return true" in {
        assertResult(true) { matcher.properties(Formats.PROPERTIES.substring(0, 1))}
      }
    }
  }
}

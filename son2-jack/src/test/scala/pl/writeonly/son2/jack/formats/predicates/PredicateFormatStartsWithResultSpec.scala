package pl.writeonly.son2.jack.formats.predicates

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.spec.WhiteResultSpec


class PredicateFormatStartsWithResultSpec extends WhiteResultSpec {
  val predicate = new PredicateFormatStartsWith()
  "A Predicate" when {
    "param is empty object json" should {
      "return true" in {
        assertResult(true) {
          predicate.on(Formats.OBJECT.name.substring(0, 1))
        }
      }
    }
    "param is empty yaml" should {
      "return true" in {
        assertResult(true) {
          predicate.yaml(Formats.YAML.name.substring(0, 1))
        }
      }
    }
    "param is empty xml" should {
      "return true" in {
        assertResult(true) {
          predicate.xml(Formats.XML.name.substring(0, 1))
        }
      }
    }
    "param is empty csv" should {
      "return true" in {
        assertResult(true) {
          predicate.csv(Formats.CSV.name.substring(0, 1))
        }
      }
    }
    "param is empty javaprops" should {
      "return true" in {
        assertResult(true) {
          predicate.javaprops(Formats.JAVA_PROPS.name.substring(0, 1))
        }
      }
    }
    "param is empty properties" should {
      "return true" in {
        assertResult(true) {
          predicate.properties(Formats.PROPERTIES.name.substring(0, 1))
        }
      }
    }
  }
}

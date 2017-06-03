package pl.writeonly.son2.jack.formats.predicates

import pl.writeonly.son2.jack.formats.creators.CreatorFormatMapper
import pl.writeonly.son2.spec.WhiteResultSpec


class PredicatFormatIsDefineResultSpec extends WhiteResultSpec {
  val predicate = new PredicateFormatIsDefine(new CreatorFormatMapper())

  "A Matcher" when {
    "param is empty object json" should {
      "return true" in {
        assertResult(true) {
          predicate.on("{}")
        }
      }
    }
    "param is empty yaml" should {
      "return true" in {
        assertResult(true) {
          predicate.yaml("---\n")
        }
      }
    }
    "param is empty xml" should {
      "return true" in {
        assertResult(true) {
          predicate.xml("<root />")
        }
      }
    }
    "param is empty csv" should {
      "return true" in {
        assertResult(true) {
          predicate.csv("\n")
        }
      }
    }
    "param is empty javaprops" should {
      "return true" in {
        assertResult(true) {
          predicate.javaprops("")
        }
      }
    }
    "param is empty properties" should {
      "return true" in {
        assertResult(true) {
          predicate.properties("")
        }
      }
    }
  }
}
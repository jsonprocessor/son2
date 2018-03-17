package pl.writeonly.son2.jack.notation

import pl.writeonly.sons.specs.WhiteAssertSpec

class NotationReaderAssertSpec extends WhiteAssertSpec {

  "A Predicate" when {
    "param is empty object json" should {
      "return true" in {
        assertResult(true) {
          new NotationReaderObject().isDefinedAt("{}")
        }
      }
    }
    "param is empty yaml" should {
      "return true" in {
        assertResult(true) {
          new NotationReaderYaml().isDefinedAt("---\n")
        }
      }
    }
    "param is empty xml" should {
      "return true" in {
        assertResult(true) {
          new NotationReaderXml().isDefinedAt("<root />\n")
        }
      }
    }
    "param is empty csv" should {
      "return true" in {
        assertResult(true) {
          new NotationReaderCsv().isDefinedAt("---\n")
        }
      }
    }
    "param is empty javaprops" should {
      "return true" in {
        assertResult(true) {
          new NotationReaderJavaProps().isDefinedAt("")
        }
      }
    }
  }
}

package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormatMapper
import pl.writeonly.son2.spec.WhiteResultSpec


class MatcherFormatIsDefineResultSpec extends WhiteResultSpec {
  val matcher = new MatcherFormatIsDefine(new CreatorFormatMapper())

  "A Matcher" when {
    "param is empty object json" should {
      "return true" in {
        assertResult(true) { matcher.on("{}")}
      }
    }
    "param is empty yaml" should {
      "return true" in {
        assertResult(true) { matcher.yaml("---\n")}
      }
    }
    "param is empty xml" should {
      "return true" in {
        assertResult(true) { matcher.xml("<root />")}
      }
    }
    "param is empty csv" should {
      "return true" in {
        assertResult(true) { matcher.csv("\n")}
      }
    }
    "param is empty javaprops" should {
      "return true" in {
        assertResult(true) { matcher.javaprops("")}
      }
    }
    "param is empty properties" should {
      "return true" in {
        assertResult(true) { matcher.properties("")}
      }
    }
  }
}

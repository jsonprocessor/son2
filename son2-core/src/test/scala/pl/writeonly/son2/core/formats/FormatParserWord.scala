package pl.writeonly.son2.core.formats

import org.scalatest.WordSpec

class FormatParserWord extends WordSpec {

  val parser = new FormatParser()

  "A parser" when {
    "param is empty object json" should {
      "return empty object" in {
        val node = parser.parse("{}")
        assert(node.isObject, "is not object")
        assert(node.size == 0, "object is not empty")
      }
    }
//    "param is empty object json" should {
//      "return empty object" in {
//        val node = parser.parse("[]")
//        assert(node.isArray, "is not array")
//        assert(node.size == 0, "array is not empty")
//      }
//    }
  }
}

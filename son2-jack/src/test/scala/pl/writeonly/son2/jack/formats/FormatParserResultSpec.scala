package pl.writeonly.son2.jack.formats

import pl.writeonly.son2.jack.glue.ChainReaderJack
import pl.writeonly.son2.spec.WhiteResultSpec

class FormatParserResultSpec extends WhiteResultSpec {

  val parser = new ChainReaderJack()

  "A parser" when {
    "param is empty object json" should {
      "return empty object" in {
        val node = parser.parse("{}")
        assertResult(true, "is not object")(node.isObject)
        assertResult(0, "object is not empty")(node.size)
      }
    }
    "param is empty array json" should {
      "return empty array" in {
        val node = parser.parse("[]")
        assertResult(true, "is not array")(node.isArray)
        assertResult(0, "array is not empty")(node.size)
      }
    }
    //    "param is empty object yaml" should {
    //      "return empty object" in {
    //        val node = parser.parse("---")
    //        assert(node.isObject, "is not object " + node)
    //        assert(node.size == 0, "object is not empty")
    //      }
    //    }
    //    "param is empty object xml" should {
    //      "return empty object" in {
    //        val node = parser.parse("<root />")
    //        assert(node.isObject, "is not object")
    //        assert(node.size == 0, "object is not empty")
    //      }
    //    }
    //    "param is empty object csv" should {
    //      "return empty object" in {
    //        val node = parser.parse("a,b,c")
    //        assert(node.isObject, "is not object")
    //        assert(node.size == 0, "object is not empty")
    //      }
    //    }
    //    "param is empty object javaprops" should {
    //      "return empty object" in {
    //        val node = parser.parse("object.property=value")
    //        assert(node.isObject, "is not object")
    //        assert(node.size == 0, "object is not empty")
    //      }
    //    }
  }
}

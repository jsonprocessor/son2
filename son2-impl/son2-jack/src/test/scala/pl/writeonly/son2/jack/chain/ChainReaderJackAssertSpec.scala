package pl.writeonly.son2.jack.chain

import pl.writeonly.son2.spec.WhiteAssertSpec

class ChainReaderJackAssertSpec extends WhiteAssertSpec {

  val parser = new ChainReaderJack()

  "A parser" when {
    "param is empty object json" should {
      "return empty object" in {
        val node = parser.parse("{}")
        assertResult(true, "is not object")(node.isObject)
        assertResult(0, "object is not empty")(node.size)
        val config = parser.configOpt("{}")
        assertResult(true, "is not defined")(config.isDefined)
      }
    }
    "param is empty array json" should {
      "return empty array" in {
        val node = parser.parse("[]")
        assertResult(true, "is not array")(node.isArray)
        assertResult(0, "array is not empty")(node.size)
        val config = parser.configOpt("[]")
        assertResult(true, "is not defined")(config.isDefined)
      }
    }
    "param is empty object yaml" should {
      "return empty object" in {
        val node = parser.parse("--- {}")
        assert(node.isObject, "is not object " + node)
        assert(node.size == 0, "object is not empty")
      }
    }
    "param is empty object xml" should {
      "return empty object" in {
        val node = parser.parse("<root></root>")
        assert(node.isObject, "is not object")
        assert(node.size == 0, "object is not empty")
        val config = parser.configOpt("<root></root>\"")
        assertResult(true, "is not defined")(config.isDefined)

      }
    }
    "param is empty object csv" should {
      "return empty object" in {
        val node = parser.parse("a,b,c")
        assert(!node.isObject, "is object")
        assert(!node.isArray, "is array")
        assert(!node.isNull, "is null")
        assert(node.isTextual, "is not type")
        assert(node.size == 0, "object is not empty")
      }
    }
    "param is empty object javaprops" should {
      "return empty object" in {
        val node = parser.parse("object.property=value")
        assert(!node.isObject, "is object")
        assert(!node.isArray, "is array")
        assert(!node.isNull, "is null")
        assert(node.isTextual, "is not type")
        assert(node.size == 0, "object is not empty")
      }
    }
  }
}

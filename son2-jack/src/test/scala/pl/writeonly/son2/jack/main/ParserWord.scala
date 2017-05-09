package pl.writeonly.son2.jack.main

import org.scalatest.{Matchers, WordSpec}
import pl.writeonly.son2.jack.core.Formats

class ParserWord extends WordSpec with Matchers {
  val parser: Parser = new Parser

  //  "A Parser" when  {
  //    "json is empty" should {
  //      val config = parser("{}")
  //      "return s equals true" in {
  //        config.s should be(true)
  //      }
  //      "return p equals true" in {
  //        config.p should be(true)
  //      }
  //      "return i equals 'object'" in {
  //        config.i should be(Formats.OBJECT)
  //      }
  //      "return o equals 'yaml'" in {
  //        config.i should be(Formats.YAML)
  //      }
  //    }
  //  }


  "A Parser" when {
    "json is default" should {
      val config = parser("{\"s\":true, \"p\":true, \"i\":\"object\", \"o\":\"yaml\"}")
      "return s equals true" in {
        config.s should be(true)
      }
      "return p equals true" in {
        config.p should be(true)
      }
      "return i equals 'object'" in {
        config.i should be(Formats.OBJECT)
      }
      "return o equals 'yaml'" in {
        config.o should be(Formats.YAML)
      }
    }
  }
}

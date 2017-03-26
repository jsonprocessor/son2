package pl.writeonly.son2.core

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import org.scalatest.{Matchers, WordSpec}
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.{Provider, ProviderXml}

class XmlWord extends WordSpec with Matchers {

  val provider: Provider = new ProviderXml()
  "A Provider" should {
    "produce JsonParseException when convert a" in {
      assertThrows[JsonParseException] {
        provider.convert("a")
      }
    }
    "produce JsonMappingException when convert empty string" in {
      assertThrows[JsonMappingException] {
        provider.convert("")
      }
    }
    "produce JsonMappingException when convert []" in {
      assertThrows[JsonMappingException] {
        provider.convert("[]")
      }
    }
    "produce JsonMappingException when convert [0,1]" in {
      assertThrows[JsonMappingException] {
        provider.convert("[0,1]")
      }
    }
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      liner.apply("") should be(provider.comment("") + "\n")
    }
  }
}
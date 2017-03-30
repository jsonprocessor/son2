package pl.writeonly.son2.impl.core

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import org.scalatest.{Matchers, WordSpec}
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.{Provider, ProviderJavaProps}
import pl.writeonly.son2.impl.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.impl.core.providers.{Provider, ProviderJavaProps}

class JavaPropsWord extends WordSpec with Matchers {

  val provider: Provider = new ProviderJavaProps()
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
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      liner.apply("") should be(provider.comment("") + "\n")
    }
  }
}

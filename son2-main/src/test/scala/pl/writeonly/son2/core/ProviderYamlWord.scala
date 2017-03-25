package pl.writeonly.son2.core

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import org.scalatest.WordSpec
import pl.writeonly.son2.core.providers.{Provider, ProviderYaml}

class ProviderYamlWord extends WordSpec {

  val provider: Provider = new ProviderYaml()

  "A Provider" should {
    "produce JsonMappingException when convert empty string" in {
      assertThrows[JsonMappingException] {
        provider.convert("")
      }
    }
    "produce JsonParseException when convert a" in {
      assertThrows[JsonParseException] {
        provider.convert("a")
      }
    }
  }
}

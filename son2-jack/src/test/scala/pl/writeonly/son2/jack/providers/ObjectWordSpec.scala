package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.{Provider, Provider2}
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.son2.spec.WhiteResultSpec

class ObjectWordSpec extends WhiteResultSpec {

  val provider: Provider = ChainNotationPairJack(FormatsJack.OBJECT)
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
      assertResult(provider.comment("") + "\n")(liner.apply(""))
    }
  }

  val providerRaw : Provider = ChainNotationPairJack(ConfigJack(o = FormatsJack.OBJECT, p = false))
  "A ProviderRaw" should {
    "have pretty == false" in {
      assertResult(false)(providerRaw.config.write.style)
    }
    "be  Provider2" in {
      assertResult(true)(providerRaw.isInstanceOf[Provider2])
    }
  }
  val provider2Raw = providerRaw.asInstanceOf[Provider2]
  "A Provider2Raw" should {
//    "have pretty == false" in {
//      assertResult(false)(provider2Raw.out.config.style)
//    }
    "be not pretty" in {
      assertResult(false)(provider2Raw.out.pretty)
    }
  }
}

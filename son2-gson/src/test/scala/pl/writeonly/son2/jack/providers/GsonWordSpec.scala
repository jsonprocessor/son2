package pl.writeonly.son2.jack.providers

import java.io.IOException

import com.google.gson.JsonParseException
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.{Provider, Provider2}
import pl.writeonly.son2.gson.core.{ConfigGson, FormatsGson}
import pl.writeonly.son2.gson.glue.CreatorProviderGson
import pl.writeonly.son2.spec.WhiteResultSpec

class GsonWordSpec extends WhiteResultSpec {

  val provider: Provider = CreatorProviderGson(FormatsGson.GSON)
  "A Provider" should {
    "produce JsonParseException when convert a" in {
      assertResult("\"a\"") (provider.convert("a"))
      assertResult("a") (provider.comment("a"))
    }
    "produce JsonMappingException when convert empty string" in {
      assertResult("null") (provider.convert(""))
      assertResult("") (provider.comment(""))
    }
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      assertResult(provider.convert("") + "\n")(liner.apply(""))
      assertResult(provider.comment("null") + "\n")(liner.apply(""))
    }
  }

  val providerRaw: Provider = CreatorProviderGson(ConfigGson(o = FormatsGson.GSON, p = false))
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
    "have pretty == false" in {
      assertResult(false)(provider2Raw.out.config.style)
    }
  }
}

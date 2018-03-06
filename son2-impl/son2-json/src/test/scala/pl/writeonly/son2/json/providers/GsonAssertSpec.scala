package pl.writeonly.son2.json.providers

import pl.writeonly.son2.core.config.WPretty
import pl.writeonly.son2.core.converters.{Converter, Converter2}
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.json.core.ConfigJson
import pl.writeonly.son2.json.glue.CreatorConverterJson
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.WhiteAssertSpec

class GsonAssertSpec extends WhiteAssertSpec {

  val provider: Converter = CreatorConverterJson(ProvidersPath.GSON)
  "A Provider" should {
    "produce JsonParseException when convert a" in {
      assertResult("\"a\"")(provider.convert("a"))
      assertResult("a")(provider.comment("a"))
    }
    "produce JsonMappingException when convert empty string" in {
      assertResult("null")(provider.convert(""))
      assertResult("")(provider.comment(""))
    }
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      assertResult(provider.convert("") + "\n")(liner.apply(""))
      assertResult(provider.comment("null") + "\n")(liner.apply(""))
    }
  }

  val providerRaw: Converter = CreatorConverterJson(
    ConfigJson(provider = ProvidersPath.GSON))
  "A ProviderRaw" should {
    "have pretty == false" in {
      assertResult(WPretty)(providerRaw.config.write.style)
    }
    "be  Provider2" in {
      assertResult(true)(providerRaw.isInstanceOf[Converter2])
    }
  }
  val provider2Raw = providerRaw.asInstanceOf[Converter2]
  "A Provider2Raw" should {
    "have pretty == false" in {
      assertResult(WPretty)(provider2Raw.out.config.style)
    }
  }
}

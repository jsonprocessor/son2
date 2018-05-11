package pl.writeonly.scallions.json.providers

import pl.writeonly.scallions.apis.config.WStyle.WPretty
import pl.writeonly.scallions.apis.converters.{Converter, Converter2}
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.json.core.ConfigJson
import pl.writeonly.scallions.json.glue.CreatorConverterJson
import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.json.core.ConfigJson
import pl.writeonly.scallions.json.glue.CreatorConverterJson
import pl.writeonly.scallions.path.core.ProvidersPath

class GsonAssertSpec extends WhiteAssertSpec {

  val provider: Converter = CreatorConverterJson(ProvidersPath.GSON).get
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
    ConfigJson(provider = ProvidersPath.GSON)
  ).get
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

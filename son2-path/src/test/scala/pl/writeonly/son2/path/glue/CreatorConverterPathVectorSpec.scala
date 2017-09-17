package pl.writeonly.son2.path.glue

import org.skyscreamer.jsonassert.JSONAssert
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterPathVectorSpec extends GrayVectorSpec {

  val providers = Table("format", ProvidersPath.ALL: _*)

  val expectedStr = "{}"
  val configer = new ChainNotationConfigPath().get
  val chain = new ChainNotationRWTPath
  val reader = chain.r
  val writer = chain.w
  property("PF should isDefinedAt for format") {
    forAll(providers) { (provider) =>
      configer.isDefinedAt(provider.name) should be(true)
      val config = configer.apply(provider.name)
      reader.isDefinedAt(config.read) should be(true)
      writer.isDefinedAt(config.write) should be(true)

      val r = reader.apply(config.read)
      val w = writer.apply(config.write)

      val json = r.apply(expectedStr)
      val actualStr = w.write(json)
      JSONAssert.assertEquals(expectedStr, actualStr, false)
      JSONAssert.assertEquals(expectedStr, actualStr, true)
    }
  }
  property("Apply creatorConverterPath by provider") {
    forAll(providers) { (provider) =>
      val converter = CreatorConverterPath.apply(provider)
      val actualStr = converter.convert(expectedStr)
      JSONAssert.assertEquals(expectedStr, actualStr, false)
      JSONAssert.assertEquals(expectedStr, actualStr, true)
    }
  }

  property("Apply creatorConverterPath by config with provider") {
    forAll(providers) { (provider) =>
      val config = Config(RConfig(provider = provider), WConfig(provider = provider))
      val converter = CreatorConverterPath.apply(config)
      val actualStr = converter.convert(expectedStr)
      JSONAssert.assertEquals(expectedStr, actualStr, false)
      JSONAssert.assertEquals(expectedStr, actualStr, true)
    }
  }

}

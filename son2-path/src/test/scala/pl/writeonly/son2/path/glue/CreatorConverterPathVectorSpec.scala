package pl.writeonly.son2.path.glue

import org.skyscreamer.jsonassert.JSONAssert
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterPathVectorSpec extends GrayVectorSpec {

  val providers = Table("format", ProvidersPath.ALL: _*)


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
      val expectedStr = "{}"
      val json = r.apply(expectedStr)
      val actualStr = w.write(json)
      JSONAssert.assertEquals(expectedStr, actualStr, false)
      JSONAssert.assertEquals(expectedStr, actualStr, true)
    }
  }
  property("Apply creatorConverterPath with format") {
    forAll(providers) { (provider) =>
      CreatorConverterPath.apply(provider)
    }
  }

}

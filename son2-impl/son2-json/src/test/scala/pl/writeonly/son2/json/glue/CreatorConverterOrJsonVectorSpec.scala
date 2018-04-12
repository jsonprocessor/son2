package pl.writeonly.son2.json.glue

import org.scalatest.Outcome
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

class CreatorConverterOrJsonVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrJson

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrJson |> test

  val providers = Table("providers", ProvidersJson.ALL: _*)

  property("Apply CreatorConverterOrJson with provider") { creator =>
    forAll(providers) { (provider) =>
      val converter = creator.converterOr(provider.name)
      converter.isGood shouldBe true
      //converter.get.metas._1 shouldBe MetaImpl(provider, Formats.OBJECT)
    }
  }
}

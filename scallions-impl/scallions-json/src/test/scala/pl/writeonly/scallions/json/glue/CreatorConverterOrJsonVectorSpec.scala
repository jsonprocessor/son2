package pl.writeonly.scallions.json.glue

import org.scalatest.Outcome
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.json.core.ProvidersJson

class CreatorConverterOrJsonVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrJson

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrJson |> test

  val providers = Table("providers", ProvidersJson.ALL: _*)

  property("Apply CreatorConverterOrJson with provider") { creator =>
    forAll(providers) { (provider) =>
      val converter = creator.converterOr(provider.name)
      withClue(s"$provider ${converter}") {
        converter.isGood shouldBe true
        converter.get.metas._1 shouldBe Meta(provider, FormatsJack.OBJECT)
        converter.get.metas._2 shouldBe Meta(provider, FormatsJack.OBJECT)
      }
    }
  }
}

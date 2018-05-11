package pl.writeonly.scallions.path.glue

import org.scalatest.Outcome
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.path.core.ProvidersPath

class CreatorConverterOrPathVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrPath

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrPath |> test

  val providers = Table("providers", ProvidersPath.ALL: _*)

  property("Apply CreatorConverterOrPath with provider") { creator =>
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

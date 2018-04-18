package pl.writeonly.son2.path.glue

import org.scalatest.Outcome
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

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

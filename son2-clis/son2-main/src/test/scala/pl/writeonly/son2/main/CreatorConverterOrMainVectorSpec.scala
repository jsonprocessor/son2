package pl.writeonly.son2.main

import org.scalatest.Outcome
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

class CreatorConverterOrMainVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrMain

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrMain |> test

  val providers = Table("format", ProvidersJson.ALL: _*)
  val formats = Table("format", FormatsJack.ALL: _*)

  property("Apply CreatorConverterOrMain with providers") { creator =>
    forAll(providers) { (provider) =>
      val converter = creator.converterOr(provider.name)
      converter.isGood shouldBe true
    }
  }

  property("Apply CreatorConverterOrMain with formats") { creator =>
    forAll(formats) { (format) =>
      val converter = creator.converterOr(format.name)
      converter.isGood shouldBe true
    }
  }

}

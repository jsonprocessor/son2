package pl.writeonly.scallions.main

import org.scalatest.Outcome
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.json.core.ProvidersJson

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

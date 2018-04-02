package pl.writeonly.son2.jack.glue

import org.scalatest.Outcome
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

class CreatorConverterOrJackVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrJack

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrJack |> test

  val formats = Table("format", FormatsJack.ALL: _*)

  property("Apply CreatorConverterOrJack with format") { creator =>
    forAll(formats) { (format) =>
      val converter = creator.converterOr(format.name)
      converter.isGood shouldBe true
    }
  }

}

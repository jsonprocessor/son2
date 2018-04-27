package pl.writeonly.son2.jack.glue

import org.scalatest.Outcome
import pl.writeonly.son2.jack.core.{FormatsJack, Jack}
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.addons.pipe.Pipe

class CreatorConverterOrJackVectorSpec extends GrayVectorSpec with Pipe {
  override type FixtureParam = CreatorConverterOrJack

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrJack |> test

  val formats = Table("formats", FormatsJack.ALL: _*)

  property("Apply CreatorConverterOrJack with format") { creator =>
    forAll(formats) { (format) =>
      val converter = creator.converterOr(format.name)
      withClue(s"$format ${converter}") {
        converter.isGood shouldBe true
        converter.get.metas._1 shouldBe Jack.meta(FormatsJack.OBJECT)
        converter.get.metas._2 shouldBe Jack.meta(format)
      }
    }
  }

}

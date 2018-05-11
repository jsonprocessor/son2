package pl.writeonly.scallions.jack.glue

import org.scalatest.Outcome
import pl.writeonly.scallions.jack.core.Jack
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.jack.core.FormatsJack

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

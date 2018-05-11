package pl.writeonly.scallions.text.glue

import org.scalatest.Outcome
import pl.writeonly.scallions.apis.config.{Meta, TConfig}
import pl.writeonly.scallions.text.core.{Actions, FormatsText}
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.apis.config.ProviderType
import pl.writeonly.scallions.text.core.{Actions, FormatsText}

//import pl.writeonly.scalaops.pipe.Pipe._

class CreatorConverterOrTextVectorSpec extends GrayVectorSpec with Pipe {

  override type FixtureParam = CreatorConverterOrText

  override protected def withFixture(test: OneArgTest): Outcome =
    new CreatorConverterOrText |> test

  val toSuccess = Table(
    ("in", "out"),
    ("e_s", TConfig(action = Actions.ESCAPE, format = FormatsText.STRING)),
    ("e_e", TConfig(action = Actions.ESCAPE, format = FormatsText.ECMASCRIPT)),
    ("e_o", TConfig(action = Actions.ESCAPE, format = FormatsText.OBJECT)),
    ("e_x", TConfig(action = Actions.ESCAPE, format = FormatsText.XML)),
    ("e_h", TConfig(action = Actions.ESCAPE, format = FormatsText.HTML4)),
    ("e_html3", TConfig(action = Actions.ESCAPE, format = FormatsText.HTML3)),
    ("e_c", TConfig(action = Actions.ESCAPE, format = FormatsText.CSV)),
    ("e_xs", TConfig(action = Actions.ESCAPE, format = FormatsText.XSI)),
    ("u_s", TConfig(action = Actions.UNESCAPE, format = FormatsText.STRING)),
    (
      "u_e",
      TConfig(action = Actions.UNESCAPE, format = FormatsText.ECMASCRIPT)
    ),
    ("u_o", TConfig(action = Actions.UNESCAPE, format = FormatsText.OBJECT)),
    ("u_x", TConfig(action = Actions.UNESCAPE, format = FormatsText.XML)),
    ("u_h", TConfig(action = Actions.UNESCAPE, format = FormatsText.HTML4)),
    ("u_html3", TConfig(action = Actions.UNESCAPE, format = FormatsText.HTML3)),
    ("u_c", TConfig(action = Actions.UNESCAPE, format = FormatsText.CSV)),
    ("u_xs", TConfig(action = Actions.UNESCAPE, format = FormatsText.XSI))
  )

  property("creatorOr create symbolPair") { creator =>
    forAll(toSuccess) { (in, out) =>
      val converter = creator converterOr in

      converter should be an 'isGood

      withClue(s"$in $out ${converter}") {
        converter.isGood shouldBe true
        converter.get.metas._1 shouldBe Meta(
          ProviderType(out.action.s),
          out.format
        )
        converter.get.metas._2 shouldBe Meta(
          ProviderType(out.action.s),
          out.format
        )
      }

    }
  }

}

package pl.writeonly.son2.text.glue

import org.scalatest.Outcome
import pl.writeonly.son2.apis.config.{Format, MetaImpl, ProviderType, TConfig}
import pl.writeonly.son2.text.core.{Actions, FormatsText}
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

//import pl.writeonly.sons.utils.ops.Pipe._

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
        converter.get.metas._1 shouldBe MetaImpl(
          ProviderType(out.action.s),
          out.format
        )
        converter.get.metas._2 shouldBe MetaImpl(
          ProviderType(out.action.s),
          out.format
        )
      }

    }
  }

}

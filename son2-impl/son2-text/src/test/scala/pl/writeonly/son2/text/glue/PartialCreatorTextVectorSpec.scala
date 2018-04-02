package pl.writeonly.son2.text.glue

import org.scalatest.Outcome
import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.text.core.{Actions, FormatsText}
import pl.writeonly.son2.text.creators.PCreatorConfigText
import pl.writeonly.sons.specs.fixture.GrayVectorSpec

import pl.writeonly.sons.utils.ops.Pipe._

class PartialCreatorTextVectorSpec extends GrayVectorSpec {

  override type FixtureParam = PCreatorConfigText

  override protected def withFixture(test: OneArgTest): Outcome =
    new PCreatorConfigText |> test

  val toSuccess = Table(
    ("in", "out"),
    ("e_s", TConfig(Actions.ESCAPE, FormatsText.STRING)),
    ("e_e", TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT)),
    ("e_o", TConfig(Actions.ESCAPE, FormatsText.OBJECT)),
    ("e_x", TConfig(Actions.ESCAPE, FormatsText.XML)),
    ("e_h", TConfig(Actions.ESCAPE, FormatsText.HTML4)),
    ("e_html3", TConfig(Actions.ESCAPE, FormatsText.HTML3)),
    ("e_c", TConfig(Actions.ESCAPE, FormatsText.CSV)),
    ("e_xs", TConfig(Actions.ESCAPE, FormatsText.XSI)),
    ("u_s", TConfig(Actions.UNESCAPE, FormatsText.STRING)),
    ("u_e", TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT)),
    ("u_o", TConfig(Actions.UNESCAPE, FormatsText.OBJECT)),
    ("u_x", TConfig(Actions.UNESCAPE, FormatsText.XML)),
    ("u_h", TConfig(Actions.UNESCAPE, FormatsText.HTML4)),
    ("u_html3", TConfig(Actions.UNESCAPE, FormatsText.HTML3)),
    ("u_c", TConfig(Actions.UNESCAPE, FormatsText.CSV)),
    ("u_xs", TConfig(Actions.UNESCAPE, FormatsText.XSI))
  )

  property("partialCreator create TranslateConfig") { partialCreator =>
    forAll(toSuccess) { (in, out) =>
      partialCreator isDefinedAt in shouldBe true
      partialCreator translateConfig in shouldBe out
    }
  }

}

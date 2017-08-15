package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Actions, FormatsText}
import pl.writeonly.son2.text.creators.PartialCreatorText

class PartialCreatorTextVectorSpec extends GrayVectorSpec {

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

  val partialCreator = new PartialCreatorText()
  property("partialCreator create TranslateConfig") {
    forAll(toSuccess) { (in, out) =>
      partialCreator isDefinedAt in should be(true)
      partialCreator translateConfig in should be(out)
    }
  }

}

package pl.writeonly.son2.text.glue

import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.text.core.{Actions, FormatsText}
import pl.writeonly.sons.specs.GrayVectorSpec

class CreatorConverterOrTextVectorSpec extends GrayVectorSpec {
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
    ("u_e",
     TConfig(action = Actions.UNESCAPE, format = FormatsText.ECMASCRIPT)),
    ("u_o", TConfig(action = Actions.UNESCAPE, format = FormatsText.OBJECT)),
    ("u_x", TConfig(action = Actions.UNESCAPE, format = FormatsText.XML)),
    ("u_h", TConfig(action = Actions.UNESCAPE, format = FormatsText.HTML4)),
    ("u_html3", TConfig(action = Actions.UNESCAPE, format = FormatsText.HTML3)),
    ("u_c", TConfig(action = Actions.UNESCAPE, format = FormatsText.CSV)),
    ("u_xs", TConfig(action = Actions.UNESCAPE, format = FormatsText.XSI))
  )

  val creator = new CreatorConverterOrText
  property("creatorOr create symbolPair") {
    forAll(toSuccess) { (in, out) =>
      creator converterOr in should be an 'isGood
    }
  }
}

package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Actions, Formats}
import pl.writeonly.son2.text.creators.PartialCreatorText

class PartialCreatorTextVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("e_j", TConfig(Actions.ESCAPE, Formats.JAVASTRING)),
    ("e_e", TConfig(Actions.ESCAPE, Formats.ECMASCRIPT)),
    ("e_o", TConfig(Actions.ESCAPE, Formats.OBJECT)),
    ("e_x", TConfig(Actions.ESCAPE, Formats.XML11)),
    ("e_h", TConfig(Actions.ESCAPE, Formats.HTML4)),
    ("e_html3", TConfig(Actions.ESCAPE, Formats.HTML3)),
    ("e_c", TConfig(Actions.ESCAPE, Formats.CSV)),
    ("e_xs", TConfig(Actions.ESCAPE, Formats.XSI)),

    ("u_j", TConfig(Actions.UNESCAPE, Formats.JAVASTRING)),
    ("u_e", TConfig(Actions.UNESCAPE, Formats.ECMASCRIPT)),
    ("u_o", TConfig(Actions.UNESCAPE, Formats.OBJECT)),
    ("u_x", TConfig(Actions.UNESCAPE, Formats.XML11)),
    ("u_h", TConfig(Actions.UNESCAPE, Formats.HTML4)),
    ("u_html3", TConfig(Actions.UNESCAPE, Formats.HTML3)),
    ("u_c", TConfig(Actions.UNESCAPE, Formats.CSV)),
    ("u_xs", TConfig(Actions.UNESCAPE, Formats.XSI))
  )

  val partialCreator = new PartialCreatorText()
  property("partialCreator create TranslateConfig") {
    forAll(toSuccess) { (in, out) =>
      partialCreator isDefinedAt in should be(true)
      partialCreator translateConfig in should be(out)
      partialCreator t in
    }
  }

}

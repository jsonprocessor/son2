package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Actions, Formats}

class CreatorProviderOrTextVectorSpec extends GrayVectorSpec {
  val toSuccess = Table(
    ("in", "out"),
    ("e_j", TConfig(action=Actions.ESCAPE, format=Formats.JAVASTRING)),
    ("e_e", TConfig(action=Actions.ESCAPE, format=Formats.ECMASCRIPT)),
    ("e_o", TConfig(action=Actions.ESCAPE, format=Formats.OBJECT)),
    ("e_x", TConfig(action=Actions.ESCAPE, format=Formats.XML11)),
    ("e_h", TConfig(action=Actions.ESCAPE, format=Formats.HTML4)),
    ("e_html3", TConfig(action=Actions.ESCAPE, format=Formats.HTML3)),
    ("e_c", TConfig(action=Actions.ESCAPE, format=Formats.CSV)),
    ("e_xs", TConfig(action=Actions.ESCAPE, format=Formats.XSI)),

    ("u_j", TConfig(action=Actions.UNESCAPE, format=Formats.JAVASTRING)),
    ("u_e", TConfig(action=Actions.UNESCAPE, format=Formats.ECMASCRIPT)),
    ("u_o", TConfig(action=Actions.UNESCAPE, format=Formats.OBJECT)),
    ("u_x", TConfig(action=Actions.UNESCAPE, format=Formats.XML11)),
    ("u_h", TConfig(action=Actions.UNESCAPE, format=Formats.HTML4)),
    ("u_html3", TConfig(action=Actions.UNESCAPE, format=Formats.HTML3)),
    ("u_c", TConfig(action=Actions.UNESCAPE, format=Formats.CSV)),
    ("u_xs", TConfig(action=Actions.UNESCAPE, format=Formats.XSI))
  )

  val creator = new CreatorProviderOrText
  property("creatorOr create symbolPair") {
    forAll(toSuccess) { (in, out) =>
      creator providerOr in should be an 'isGood
    }
  }
}

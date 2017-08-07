package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Escapes, Formats}

class CreatorProviderOrTextVectorSpec extends GrayVectorSpec {
  val toSuccess = Table(
    ("in", "out"),
    ("e_j", TConfig(Escapes.ESCAPE, Formats.JAVASTRING)),
    ("e_e", TConfig(Escapes.ESCAPE, Formats.ECMASCRIPT)),
    ("e_o", TConfig(Escapes.ESCAPE, Formats.OBJECT)),
    ("e_x", TConfig(Escapes.ESCAPE, Formats.XML11)),
    ("e_h", TConfig(Escapes.ESCAPE, Formats.HTML4)),
    ("e_html3", TConfig(Escapes.ESCAPE, Formats.HTML3)),
    ("e_c", TConfig(Escapes.ESCAPE, Formats.CSV)),
    ("e_xs", TConfig(Escapes.ESCAPE, Formats.XSI)),

    ("u_j", TConfig(Escapes.UNESCAPE, Formats.JAVASTRING)),
    ("u_e", TConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT)),
    ("u_o", TConfig(Escapes.UNESCAPE, Formats.OBJECT)),
    ("u_x", TConfig(Escapes.UNESCAPE, Formats.XML11)),
    ("u_h", TConfig(Escapes.UNESCAPE, Formats.HTML4)),
    ("u_html3", TConfig(Escapes.UNESCAPE, Formats.HTML3)),
    ("u_c", TConfig(Escapes.UNESCAPE, Formats.CSV)),
    ("u_xs", TConfig(Escapes.UNESCAPE, Formats.XSI))
  )

  val creator = new CreatorProviderOrText
  property("creatorOr create symbolPair") {
    forAll(toSuccess) { (in, out) =>
      creator providerOr in should be an 'isGood
    }
  }
}

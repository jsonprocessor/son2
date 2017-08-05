package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TranslateConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Escapes, Formats}

class CreatorProviderOrTextVectorSpec extends GrayVectorSpec {
  val toSuccess = Table(
    ("in", "out"),
    ("e_j", TranslateConfig(Escapes.ESCAPE, Formats.JAVASTRING)),
    ("e_e", TranslateConfig(Escapes.ESCAPE, Formats.ECMASCRIPT)),
    ("e_o", TranslateConfig(Escapes.ESCAPE, Formats.OBJECT)),
    ("e_x", TranslateConfig(Escapes.ESCAPE, Formats.XML)),
    ("e_h", TranslateConfig(Escapes.ESCAPE, Formats.HTML4)),
    ("e_html3", TranslateConfig(Escapes.ESCAPE, Formats.HTML3)),
    ("e_c", TranslateConfig(Escapes.ESCAPE, Formats.CSV)),
    ("e_xs", TranslateConfig(Escapes.ESCAPE, Formats.XSI)),

    ("u_j", TranslateConfig(Escapes.UNESCAPE, Formats.JAVASTRING)),
    ("u_e", TranslateConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT)),
    ("u_o", TranslateConfig(Escapes.UNESCAPE, Formats.OBJECT)),
    ("u_x", TranslateConfig(Escapes.UNESCAPE, Formats.XML)),
    ("u_h", TranslateConfig(Escapes.UNESCAPE, Formats.HTML4)),
    ("u_html3", TranslateConfig(Escapes.UNESCAPE, Formats.HTML3)),
    ("u_c", TranslateConfig(Escapes.UNESCAPE, Formats.CSV)),
    ("u_xs", TranslateConfig(Escapes.UNESCAPE, Formats.XSI))
  )

  val creator = new CreatorProviderOrText
  property("creatorOr create symbolPair") {
    forAll(toSuccess) { (in, out) =>
      creator provider in should be an 'isGood
    }
  }
}

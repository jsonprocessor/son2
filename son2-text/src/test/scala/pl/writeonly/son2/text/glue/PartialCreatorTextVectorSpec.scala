package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.config.TranslateConfig
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.text.core.{Escapes, Formats}
import pl.writeonly.son2.text.creators.PartialCreatorText

class PartialCreatorTextVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("e_ja", TranslateConfig(Escapes.ESCAPE, Formats.JAVA)),
    ("e_js", TranslateConfig(Escapes.ESCAPE, Formats.JSON)),
    ("u_ja", TranslateConfig(Escapes.UNESCAPE, Formats.JAVA)),
    ("u_js", TranslateConfig(Escapes.UNESCAPE, Formats.JSON))

  )

  val partialCreator = new PartialCreatorText()
  property("partialCreator create symbolPair") {
    forAll(toSuccess) { (in, out) =>
      partialCreator isDefinedAt in should be (true)
      partialCreator symbolPair in should be (out)
    }
  }

}

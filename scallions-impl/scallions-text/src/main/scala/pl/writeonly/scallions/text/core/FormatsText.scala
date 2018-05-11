package pl.writeonly.scallions.text.core

import pl.writeonly.scallions.apis.config.Format
import pl.writeonly.scallions.apis.core.Formats

object FormatsText extends Formats {
  val STRING = Format('string)
  val JAVA_STR = Format('javastr)
  val ECMASCRIPT = Format('ecmascript)
  val JAVA_SCRIPT = Format('javascript)
  val XML11 = Format('xml11)
  val XML10 = Format('xml10)
  val HTML5 = Format('html5)
  val HTML4 = Format('html4)
  val HTML3 = Format('html3)
  val XSI = Format('xsi)
  val URI = Format('url)
  val CSS = Format('css)

  val ALL_TEXT = ALL ++ List(
    STRING,
    JAVA_STR,
    ECMASCRIPT,
    JAVA_SCRIPT,
    XML11,
    XML10,
    HTML4,
    HTML3,
    XSI,
    URI,
    CSS
  )

  val SED = 'sed
}

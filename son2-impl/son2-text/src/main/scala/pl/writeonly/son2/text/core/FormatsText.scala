package pl.writeonly.son2.text.core

import pl.writeonly.son2.core.core.Formats

object FormatsText extends Formats {
  val STRING = 'string
  val JAVA_STR = 'javastr
  val ECMASCRIPT = 'ecmascript
  val JAVA_SCRIPT = 'javascript
  val XML11 = 'xml11
  val XML10 = 'xml10
  val HTML5 = 'html5
  val HTML4 = 'html4
  val HTML3 = 'html3
  val XSI = 'xsi
  val URI = 'url
  val CSS = 'css

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
    CSS)

  val SED = 'sed
}

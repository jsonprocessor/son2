package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.text.core.{Actions, FormatsText}

class MatcherStringEscape extends Matcher {

  type Transformer = CharSequenceTranslator

  override def extract(d: CharSequenceTranslator) = d.translate

  @volatile lazy val pf
    : PF = xml orElse html orElse json orElse csv orElse java orElse ecmaScript orElse xsi

  val xml: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.XML, _) =>
      StringEscapeUtils.ESCAPE_XML11
    case TConfig(Actions.ESCAPE, FormatsText.XML11, _) =>
      StringEscapeUtils.ESCAPE_XML11
    case TConfig(Actions.ESCAPE, FormatsText.XML10, _) =>
      StringEscapeUtils.ESCAPE_XML10
    case TConfig(Actions.UNESCAPE, FormatsText.XML, _) =>
      StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, _) =>
      StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, _) =>
      StringEscapeUtils.UNESCAPE_XML
  }

  val html: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.HTML4, _) =>
      StringEscapeUtils.ESCAPE_HTML4
    case TConfig(Actions.ESCAPE, FormatsText.HTML3, _) =>
      StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, _) =>
      StringEscapeUtils.UNESCAPE_HTML4
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, _) =>
      StringEscapeUtils.UNESCAPE_HTML3
  }

  val json: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, _) =>
      StringEscapeUtils.ESCAPE_JSON
    case TConfig(Actions.UNESCAPE, FormatsText.OBJECT, _) =>
      StringEscapeUtils.UNESCAPE_JSON

  }

  val csv: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.CSV, _) =>
      StringEscapeUtils.ESCAPE_CSV
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, _) =>
      StringEscapeUtils.UNESCAPE_CSV
  }

  val java: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, _) =>
      StringEscapeUtils.ESCAPE_JAVA
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, _) =>
      StringEscapeUtils.UNESCAPE_JAVA
  }

  val ecmaScript: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, _) =>
      StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, _) =>
      StringEscapeUtils.UNESCAPE_ECMASCRIPT
  }

  val xsi: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.XSI, _) =>
      StringEscapeUtils.ESCAPE_XSI
    case TConfig(Actions.UNESCAPE, FormatsText.XSI, _) =>
      StringEscapeUtils.UNESCAPE_XSI
  }

}

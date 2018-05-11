package pl.writeonly.son2.text.creators

import org.unbescape.css.CssEscape
import org.unbescape.csv.CsvEscape
import org.unbescape.html.HtmlEscape
import org.unbescape.java.JavaEscape
import org.unbescape.javascript.JavaScriptEscape
import org.unbescape.json.JsonEscape
import org.unbescape.uri.UriEscape
import org.unbescape.xml.XmlEscape
import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.apis.core.core.DString
import pl.writeonly.son2.text.core.{Actions, FormatsText}

class MatcherUnbescape extends Matcher {

  type Transformer = DString

  override def extract(d: DString): DString = d

  @volatile lazy val pf
    : PF = xml orElse html orElse json orElse csv orElse java orElse ecmaScript orElse uri orElse css

  val xml: PF = {
    case TConfig(Actions.UNESCAPE, FormatsText.XML, _) =>
      (s: String) =>
        XmlEscape.escapeXml11(s)
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, _) =>
      XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, _) =>
      XmlEscape.escapeXml11
  }

  val html: PF = {
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, _) =>
      HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, _) =>
      HtmlEscape.unescapeHtml
  }

  val csv: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.CSV, _)   => CsvEscape.escapeCsv
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, _) => CsvEscape.unescapeCsv
  }

  val json: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, _) =>
      JsonEscape.escapeJson
  }

  val java: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, _) =>
      JavaEscape.escapeJava
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, _) =>
      JavaEscape.unescapeJava
  }

  val ecmaScript: PF = {
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, _) =>
      JavaScriptEscape.escapeJavaScript
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, _) =>
      JavaScriptEscape.unescapeJavaScript
  }

  val uri: PF = {
    case TConfig(Actions.UNESCAPE, FormatsText.URI, _) =>
      UriEscape.unescapeUriPath
  }

  val css: PF = {
    case TConfig(Actions.UNESCAPE, FormatsText.CSS, _) => CssEscape.unescapeCss
  }

}

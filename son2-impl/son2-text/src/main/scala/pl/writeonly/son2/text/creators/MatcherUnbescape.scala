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

  override def apply(p: TConfig): DString = p match {
    case TConfig(Actions.ESCAPE, _, _)   => escape(p)
    case TConfig(Actions.UNESCAPE, _, _) => unescape(p)
  }

  def escape(p: TConfig): DString = p match {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, _) =>
      JavaEscape.escapeJava
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, _) =>
      JavaScriptEscape.escapeJavaScript
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, _) =>
      JsonEscape.escapeJson
    case TConfig(Actions.ESCAPE, FormatsText.CSV, _) => CsvEscape.escapeCsv
  }

  def unescape(p: TConfig): DString = p match {
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, _) =>
      JavaEscape.unescapeJava
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, _) =>
      JavaScriptEscape.unescapeJavaScript
    case TConfig(Actions.UNESCAPE, FormatsText.XML, _) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, _) =>
      XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, _) =>
      XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, _) =>
      HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, _) =>
      HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, _) => CsvEscape.unescapeCsv
    case TConfig(Actions.UNESCAPE, FormatsText.URI, _) =>
      UriEscape.unescapeUriPath
    case TConfig(Actions.UNESCAPE, FormatsText.CSS, _) => CssEscape.unescapeCss
  }
}

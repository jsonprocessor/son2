package pl.writeonly.son2.text.creators

import org.unbescape.css.CssEscape
import org.unbescape.csv.CsvEscape
import org.unbescape.html.HtmlEscape
import org.unbescape.java.JavaEscape
import org.unbescape.javascript.JavaScriptEscape
import org.unbescape.json.JsonEscape
import org.unbescape.properties.PropertiesEscape
import org.unbescape.uri.UriEscape
import org.unbescape.xml.XmlEscape
import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.core.core.DString
import pl.writeonly.son2.text.core.{Actions, FormatsText}

class MatcherUnbescape extends Matcher {

  override def apply(p: TConfig): DString = p match {
    case TConfig(Actions.ESCAPE, _, _)   => escape(p)
    case TConfig(Actions.UNESCAPE, _, _) => unescape(p)
  }

  def escape(p: TConfig): DString = p match {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, l) =>
      JavaEscape.escapeJava
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, l) =>
      JavaScriptEscape.escapeJavaScript
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, l) =>
      JsonEscape.escapeJson
    case TConfig(Actions.ESCAPE, FormatsText.CSV, l) => CsvEscape.escapeCsv
  }

  def unescape(p: TConfig): DString = p match {
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, l) =>
      JavaEscape.unescapeJava
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, l) =>
      JavaScriptEscape.unescapeJavaScript
    case TConfig(Actions.UNESCAPE, FormatsText.XML, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, l) =>
      XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, l) =>
      XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, l) =>
      HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, l) =>
      HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, l) => CsvEscape.unescapeCsv
    case TConfig(Actions.UNESCAPE, FormatsText.URI, l) =>
      UriEscape.unescapeUriPath
    case TConfig(Actions.UNESCAPE, FormatsText.CSS, l) => CssEscape.unescapeCss
  }
}

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
import pl.writeonly.son2.text.core.{Actions, FormatsText}

class MatcherUnbescape extends Matcher {

  override def apply(p: TConfig) = p match {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, l) => JavaEscape.escapeJava
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, l) => JavaScriptEscape.escapeJavaScript
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, l) => JsonEscape.escapeJson
    //    case TranslateConfig(Escapes.ESCAPE, Formats.XML) => StringEscapeUtils.ESCAPE_XML11
    //    case TranslateConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
    //    case TranslateConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Actions.ESCAPE, FormatsText.CSV, l) => CsvEscape.escapeCsv
    //    case TranslateConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, l) => JavaEscape.unescapeJava
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, l) => JavaScriptEscape.unescapeJavaScript
    //    case TranslateConfig(Escapes.UNESCAPE, Formats.OBJECT) => StringEscapeUtils.UNESCAPE_JSON
    case TConfig(Actions.UNESCAPE, FormatsText.XML, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, l) => HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, l) => HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, l) => CsvEscape.unescapeCsv
    //    case TranslateConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
    case TConfig(Actions.UNESCAPE, FormatsText.URI, l) => UriEscape.unescapeUriPath
    case TConfig(Actions.UNESCAPE, FormatsText.CSS, l) => CssEscape.unescapeCss
    case TConfig(Actions.UNESCAPE, FormatsText.CSS, l) => PropertiesEscape.unescapeProperties


  }
}

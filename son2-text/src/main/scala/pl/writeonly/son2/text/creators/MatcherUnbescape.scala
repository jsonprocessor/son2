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
import pl.writeonly.son2.text.core.{Actions, Formats}

class MatcherUnbescape extends Matcher {

  override def apply(p: TConfig) = p match {
    case TConfig(Actions.ESCAPE, Formats.JAVASTRING, l) => JavaEscape.escapeJava
    case TConfig(Actions.ESCAPE, Formats.ECMASCRIPT, l) => JavaScriptEscape.escapeJavaScript
    case TConfig(Actions.ESCAPE, Formats.OBJECT, l) =>  JsonEscape.escapeJson
//    case TranslateConfig(Escapes.ESCAPE, Formats.XML) => StringEscapeUtils.ESCAPE_XML11
//    case TranslateConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
//    case TranslateConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Actions.ESCAPE, Formats.CSV, l) => CsvEscape.escapeCsv
//    case TranslateConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TConfig(Actions.UNESCAPE, Formats.JAVASTRING, l) => JavaEscape.unescapeJava
    case TConfig(Actions.UNESCAPE, Formats.ECMASCRIPT, l) => JavaScriptEscape.unescapeJavaScript
//    case TranslateConfig(Escapes.UNESCAPE, Formats.OBJECT) => StringEscapeUtils.UNESCAPE_JSON
    case TConfig(Actions.UNESCAPE, Formats.XML11, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, Formats.XML10, l) => XmlEscape.escapeXml11
    case TConfig(Actions.UNESCAPE, Formats.HTML4, l) => HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, Formats.HTML3, l) => HtmlEscape.unescapeHtml
    case TConfig(Actions.UNESCAPE, Formats.CSV, l) => CsvEscape.unescapeCsv
//    case TranslateConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
    case TConfig(Actions.UNESCAPE, Formats.URI, l) => UriEscape.unescapeUriPath
    case TConfig(Actions.UNESCAPE, Formats.CSS, l) => CssEscape.unescapeCss
    case TConfig(Actions.UNESCAPE, Formats.CSS, l) => PropertiesEscape.unescapeProperties

  }
}

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
import pl.writeonly.son2.core.config.TranslateConfig
import pl.writeonly.son2.text.core.{Escapes, Formats}

class MatcherUnbescape extends Matcher {

  override def apply(p: TranslateConfig) = p match {
    case TranslateConfig(Escapes.ESCAPE, Formats.JAVASTRING) => JavaEscape.escapeJava
    case TranslateConfig(Escapes.ESCAPE, Formats.ECMASCRIPT) => JavaScriptEscape.escapeJavaScript
    case TranslateConfig(Escapes.ESCAPE, Formats.OBJECT) =>  JsonEscape.escapeJson
//    case TranslateConfig(Escapes.ESCAPE, Formats.XML) => StringEscapeUtils.ESCAPE_XML11
//    case TranslateConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
//    case TranslateConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TranslateConfig(Escapes.ESCAPE, Formats.CSV) => CsvEscape.escapeCsv
//    case TranslateConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TranslateConfig(Escapes.UNESCAPE, Formats.JAVASTRING) => JavaEscape.unescapeJava
    case TranslateConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT) => JavaScriptEscape.unescapeJavaScript
//    case TranslateConfig(Escapes.UNESCAPE, Formats.OBJECT) => StringEscapeUtils.UNESCAPE_JSON
    case TranslateConfig(Escapes.UNESCAPE, Formats.XML11) => XmlEscape.escapeXml11
    case TranslateConfig(Escapes.UNESCAPE, Formats.XML10) => XmlEscape.escapeXml11
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML4) => HtmlEscape.unescapeHtml
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML3) => HtmlEscape.unescapeHtml
    case TranslateConfig(Escapes.UNESCAPE, Formats.CSV) => CsvEscape.unescapeCsv
//    case TranslateConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
    case TranslateConfig(Escapes.UNESCAPE, Formats.URI) => UriEscape.unescapeUriPath
    case TranslateConfig(Escapes.UNESCAPE, Formats.CSS) => CssEscape.unescapeCss
    case TranslateConfig(Escapes.UNESCAPE, Formats.CSS) => PropertiesEscape.unescapeProperties

  }
}

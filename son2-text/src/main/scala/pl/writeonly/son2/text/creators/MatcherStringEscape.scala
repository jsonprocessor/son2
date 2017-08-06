package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.TranslateConfig
import pl.writeonly.son2.text.core.{Escapes, Formats}

class MatcherStringEscape extends Matcher {
  def translatorMatch(p: TranslateConfig): CharSequenceTranslator = p match {
    case TranslateConfig(Escapes.ESCAPE, Formats.JAVASTRING) => StringEscapeUtils.ESCAPE_JAVA
    case TranslateConfig(Escapes.ESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TranslateConfig(Escapes.ESCAPE, Formats.OBJECT) => StringEscapeUtils.ESCAPE_JSON
    case TranslateConfig(Escapes.ESCAPE, Formats.XML) => StringEscapeUtils.ESCAPE_XML11
    case TranslateConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
    case TranslateConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TranslateConfig(Escapes.ESCAPE, Formats.CSV) => StringEscapeUtils.ESCAPE_CSV
    case TranslateConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TranslateConfig(Escapes.UNESCAPE, Formats.JAVASTRING) => StringEscapeUtils.UNESCAPE_JAVA
    case TranslateConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.UNESCAPE_ECMASCRIPT
    case TranslateConfig(Escapes.UNESCAPE, Formats.OBJECT) => StringEscapeUtils.UNESCAPE_JSON
    case TranslateConfig(Escapes.UNESCAPE, Formats.XML) => StringEscapeUtils.UNESCAPE_XML
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML4) => StringEscapeUtils.UNESCAPE_HTML4
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML3) => StringEscapeUtils.UNESCAPE_HTML3
    case TranslateConfig(Escapes.UNESCAPE, Formats.CSV) => StringEscapeUtils.UNESCAPE_CSV
    case TranslateConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
  }
}

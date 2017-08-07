package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.text.core.{Escapes, Formats}

class MatcherStringEscape extends Matcher {

  override def apply(p: TConfig): (String) => String = translatorMatch(p).translate

  def translatorMatch(p: TConfig): CharSequenceTranslator = p match {
    case TConfig(Escapes.ESCAPE, Formats.JAVASTRING) => StringEscapeUtils.ESCAPE_JAVA
    case TConfig(Escapes.ESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TConfig(Escapes.ESCAPE, Formats.OBJECT) => StringEscapeUtils.ESCAPE_JSON
    case TConfig(Escapes.ESCAPE, Formats.XML11) => StringEscapeUtils.ESCAPE_XML11
    case TConfig(Escapes.ESCAPE, Formats.XML10) => StringEscapeUtils.ESCAPE_XML10
    case TConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
    case TConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Escapes.ESCAPE, Formats.CSV) => StringEscapeUtils.ESCAPE_CSV
    case TConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TConfig(Escapes.UNESCAPE, Formats.JAVASTRING) => StringEscapeUtils.UNESCAPE_JAVA
    case TConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.UNESCAPE_ECMASCRIPT
    case TConfig(Escapes.UNESCAPE, Formats.OBJECT) => StringEscapeUtils.UNESCAPE_JSON
    case TConfig(Escapes.UNESCAPE, Formats.XML11) => StringEscapeUtils.UNESCAPE_XML
    case TConfig(Escapes.UNESCAPE, Formats.XML10) => StringEscapeUtils.UNESCAPE_XML
    case TConfig(Escapes.UNESCAPE, Formats.HTML4) => StringEscapeUtils.UNESCAPE_HTML4
    case TConfig(Escapes.UNESCAPE, Formats.HTML3) => StringEscapeUtils.UNESCAPE_HTML3
    case TConfig(Escapes.UNESCAPE, Formats.CSV) => StringEscapeUtils.UNESCAPE_CSV
    case TConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
  }

}

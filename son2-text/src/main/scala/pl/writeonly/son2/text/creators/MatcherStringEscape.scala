package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.text.core.{Actions, Formats}

class MatcherStringEscape extends Matcher {

  override def apply(p: TConfig): (String) => String = translatorMatch(p).translate

  def translatorMatch(p: TConfig): CharSequenceTranslator = p match {
    case TConfig(Actions.ESCAPE, Formats.JAVASTRING, l) => StringEscapeUtils.ESCAPE_JAVA
    case TConfig(Actions.ESCAPE, Formats.ECMASCRIPT, l) => StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TConfig(Actions.ESCAPE, Formats.OBJECT, l) => StringEscapeUtils.ESCAPE_JSON
    case TConfig(Actions.ESCAPE, Formats.XML11, l) => StringEscapeUtils.ESCAPE_XML11
    case TConfig(Actions.ESCAPE, Formats.XML10, l) => StringEscapeUtils.ESCAPE_XML10
    case TConfig(Actions.ESCAPE, Formats.HTML4, l) => StringEscapeUtils.ESCAPE_HTML4
    case TConfig(Actions.ESCAPE, Formats.HTML3, l) => StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Actions.ESCAPE, Formats.CSV, l) => StringEscapeUtils.ESCAPE_CSV
    case TConfig(Actions.ESCAPE, Formats.XSI, l) => StringEscapeUtils.ESCAPE_XSI
    case TConfig(Actions.UNESCAPE, Formats.JAVASTRING, l) => StringEscapeUtils.UNESCAPE_JAVA
    case TConfig(Actions.UNESCAPE, Formats.ECMASCRIPT, l) => StringEscapeUtils.UNESCAPE_ECMASCRIPT
    case TConfig(Actions.UNESCAPE, Formats.OBJECT, l) => StringEscapeUtils.UNESCAPE_JSON
    case TConfig(Actions.UNESCAPE, Formats.XML11, l) => StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, Formats.XML10, l) => StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, Formats.HTML4, l) => StringEscapeUtils.UNESCAPE_HTML4
    case TConfig(Actions.UNESCAPE, Formats.HTML3, l) => StringEscapeUtils.UNESCAPE_HTML3
    case TConfig(Actions.UNESCAPE, Formats.CSV, l) => StringEscapeUtils.UNESCAPE_CSV
    case TConfig(Actions.UNESCAPE, Formats.XSI, l) => StringEscapeUtils.UNESCAPE_XSI
  }

}

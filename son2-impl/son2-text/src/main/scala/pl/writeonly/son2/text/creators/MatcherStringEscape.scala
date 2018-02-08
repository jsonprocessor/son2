package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.text.core.{Actions, FormatsText}

class MatcherStringEscape extends Matcher {

  override def apply(p: TConfig): CString =
    translatorMatch(p).translate

  def translatorMatch(p: TConfig): CharSequenceTranslator = p match {
    case TConfig(Actions.ESCAPE, _, _)   => translatorEscape(p)
    case TConfig(Actions.UNESCAPE, _, _) => translatorUnescape(p)
  }

  def translatorEscape(p: TConfig): CharSequenceTranslator = p match {
    case TConfig(Actions.ESCAPE, FormatsText.STRING, l) =>
      StringEscapeUtils.ESCAPE_JAVA
    case TConfig(Actions.ESCAPE, FormatsText.ECMASCRIPT, l) =>
      StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TConfig(Actions.ESCAPE, FormatsText.OBJECT, l) =>
      StringEscapeUtils.ESCAPE_JSON
    case TConfig(Actions.ESCAPE, FormatsText.XML, l) =>
      StringEscapeUtils.ESCAPE_XML11
    case TConfig(Actions.ESCAPE, FormatsText.XML11, l) =>
      StringEscapeUtils.ESCAPE_XML11
    case TConfig(Actions.ESCAPE, FormatsText.XML10, l) =>
      StringEscapeUtils.ESCAPE_XML10
    case TConfig(Actions.ESCAPE, FormatsText.HTML4, l) =>
      StringEscapeUtils.ESCAPE_HTML4
    case TConfig(Actions.ESCAPE, FormatsText.HTML3, l) =>
      StringEscapeUtils.ESCAPE_HTML3
    case TConfig(Actions.ESCAPE, FormatsText.CSV, l) =>
      StringEscapeUtils.ESCAPE_CSV
    case TConfig(Actions.ESCAPE, FormatsText.XSI, l) =>
      StringEscapeUtils.ESCAPE_XSI
  }

  def translatorUnescape(p: TConfig): CharSequenceTranslator = p match {
    case TConfig(Actions.UNESCAPE, FormatsText.STRING, l) =>
      StringEscapeUtils.UNESCAPE_JAVA
    case TConfig(Actions.UNESCAPE, FormatsText.ECMASCRIPT, l) =>
      StringEscapeUtils.UNESCAPE_ECMASCRIPT
    case TConfig(Actions.UNESCAPE, FormatsText.OBJECT, l) =>
      StringEscapeUtils.UNESCAPE_JSON
    case TConfig(Actions.UNESCAPE, FormatsText.XML, l) =>
      StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, FormatsText.XML11, l) =>
      StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, FormatsText.XML10, l) =>
      StringEscapeUtils.UNESCAPE_XML
    case TConfig(Actions.UNESCAPE, FormatsText.HTML4, l) =>
      StringEscapeUtils.UNESCAPE_HTML4
    case TConfig(Actions.UNESCAPE, FormatsText.HTML3, l) =>
      StringEscapeUtils.UNESCAPE_HTML3
    case TConfig(Actions.UNESCAPE, FormatsText.CSV, l) =>
      StringEscapeUtils.UNESCAPE_CSV
    case TConfig(Actions.UNESCAPE, FormatsText.XSI, l) =>
      StringEscapeUtils.UNESCAPE_XSI
  }

}

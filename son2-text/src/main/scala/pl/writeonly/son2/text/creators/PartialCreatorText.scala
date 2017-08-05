package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.{Config, TranslateConfig}
import pl.writeonly.son2.core.notation.{NotationPair, NotationTranslator, PartialCreator}
import pl.writeonly.son2.text.core.{Escapes, Formats}

class PartialCreatorText extends PartialCreator {

  override def isDefinedAt(s: String) = s != null &&
    regex(s).isDefined &&
    symbolOptionPairOption(s).map(isDefined).getOrElse(false)

  override def c = (s: String) => new Config(translate = translateConfig(s))

  override def t(s:String) = new NotationTranslator(translatorMatch(translateConfig(s)).translate)

  def translateConfig(s:String):TranslateConfig = symbolOptionPairOption(s)
    .map(p =>  TranslateConfig(p._1.get, p._2.get))
    .get

  private def regex(s:String) = "^(\\w+)_(\\w+)$".r.findFirstMatchIn(s)

  private def symbolOptionPairOption(s:String):Option[(Option[Symbol],Option[Symbol])] = regex(s)
    .map(p => Pair(p.group(1), p.group(2)))
    .map(p => Pair(find(p._1, Escapes.ALL), find(p._2, Formats.ALL)))

  private def isDefined(p:Tuple2[Option[Symbol],Option[Symbol]]): Boolean = p._1.isDefined && p._2.isDefined

  private def find(s:String, l:List[Symbol]) = l.find(it => it.name.toLowerCase.startsWith(s))

  def translatorMatch(p:TranslateConfig) : CharSequenceTranslator = p match {
    case TranslateConfig(Escapes.ESCAPE, Formats.JAVA) => StringEscapeUtils.ESCAPE_JAVA
    case TranslateConfig(Escapes.ESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.ESCAPE_ECMASCRIPT
    case TranslateConfig(Escapes.ESCAPE, Formats.JSON) => StringEscapeUtils.ESCAPE_JSON
    case TranslateConfig(Escapes.ESCAPE, Formats.XML) => StringEscapeUtils.ESCAPE_XML11
    case TranslateConfig(Escapes.ESCAPE, Formats.HTML4) => StringEscapeUtils.ESCAPE_HTML4
    case TranslateConfig(Escapes.ESCAPE, Formats.HTML3) => StringEscapeUtils.ESCAPE_HTML3
    case TranslateConfig(Escapes.ESCAPE, Formats.CSV) => StringEscapeUtils.ESCAPE_CSV
    case TranslateConfig(Escapes.ESCAPE, Formats.XSI) => StringEscapeUtils.ESCAPE_XSI
    case TranslateConfig(Escapes.UNESCAPE, Formats.JAVA) => StringEscapeUtils.UNESCAPE_JAVA
    case TranslateConfig(Escapes.UNESCAPE, Formats.ECMASCRIPT) => StringEscapeUtils.UNESCAPE_ECMASCRIPT
    case TranslateConfig(Escapes.UNESCAPE, Formats.JSON) => StringEscapeUtils.UNESCAPE_JSON
    case TranslateConfig(Escapes.UNESCAPE, Formats.XML) => StringEscapeUtils.UNESCAPE_XML
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML4) => StringEscapeUtils.UNESCAPE_HTML4
    case TranslateConfig(Escapes.UNESCAPE, Formats.HTML3) => StringEscapeUtils.UNESCAPE_HTML3
    case TranslateConfig(Escapes.UNESCAPE, Formats.CSV) => StringEscapeUtils.UNESCAPE_CSV
    case TranslateConfig(Escapes.UNESCAPE, Formats.XSI) => StringEscapeUtils.UNESCAPE_XSI
  }

}

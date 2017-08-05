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

  override def apply(s: String): NotationPair = NotationPair(c, null, null, notationTranslator(s))

  def c(path: String) = new Config(translate = symbolPair(path))

  def notationTranslator(s:String) =  new NotationTranslator(translator(symbolPair(s)))

  def translator(p:TranslateConfig) : String => String = translatorMatch(p).translate
  
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

  def symbolPair(s:String):TranslateConfig = symbolOptionPairOption(s).map(it => TranslateConfig(it._1.get, it._2.get)).get

  private def regex(s:String) = "^(\\w+)_(\\w+)$".r.findFirstMatchIn(s)

  private def symbolOptionPairOption(s:String):Option[Tuple2[Option[Symbol],Option[Symbol]]] = regex(s)
    .map(p => Pair(p.group(1), p.group(2)))
    .map(p => Pair(escape(p._1), format(p._2)))

  private def isDefined(p:Tuple2[Option[Symbol],Option[Symbol]]): Boolean = p._1.isDefined && p._2.isDefined

  private def escape(s:String) = a(s, Escapes.ALL)

  private def format(s:String) = a(s, Formats.ALL)

  private def a(s:String, l:List[Symbol]) = l.find(it => it.name.toLowerCase.startsWith(s))


}

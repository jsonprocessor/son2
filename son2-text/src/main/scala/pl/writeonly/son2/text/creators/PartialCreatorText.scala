package pl.writeonly.son2.text.creators

import org.apache.commons.text.StringEscapeUtils
import pl.writeonly.son2.core.notation.{NotationPair, PartialCreator}
import pl.writeonly.son2.text.core.{Escapes, Formats}

class PartialCreatorText extends PartialCreator {

  val a = new StringEscapeUtils()

  override def isDefinedAt(s: String) = s != null && regex(s).isDefined && pair(s).map(isDefined).getOrElse(false)

  override def apply(s: String) = get(s) match {
//    case Pair(Escapes.ESCAPE, Formats.JAVA) => StringEscapeUtils.ESCAPE_JAVA
    case _ => ???
  }

  private def get(s:String):Tuple2[Symbol,Symbol] = pair(s).map(it => Pair(it._1.get, it._2.get)).get

  private def regex(s:String) = "$(\\w+)_(\\w+)^".r.findFirstMatchIn(s)

  private def pair(s:String):Option[Tuple2[Option[Symbol],Option[Symbol]]] = regex(s)
    .map(p => Pair(p.group(1), p.group(2)))
    .map(p => Pair(escape(p._1), format(p._2)))

  private def isDefined(p:Tuple2[Option[Symbol],Option[Symbol]]): Boolean = p._1.isDefined && p._2.isDefined

  private def escape(s:String) = a(s, Escapes.ALL)

  private def format(s:String) = a(s, Formats.ALL)

  private def a(s:String, l:List[Symbol]) = l.find(it => it.name.toLowerCase.startsWith(s))



  //  def valid(resource: String) = Resources.ALL
  //    .find(it => it.toLowerCase.startsWith(resource))
  //    .getOrElse({
  //      println(Resources.UNKNOWN_FORMAT + resource)
  //      Resources.README
  //    })

}

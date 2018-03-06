package pl.writeonly.son2.core.config

case class Config(read: RConfig = RConfig(),
                  write: WConfig = WConfig(),
                  translate: TConfig = TConfig())

case class RConfig(provider: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   stream: RStyle = RStream,
                   path: RPath = RPath.json,
                   options: Set[Symbol] = Set())

case class WConfig(provider: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   style: WStyle = WPretty,
                   addEndLine: Boolean = true,
                   gson: Set[Symbol] = Set())

case class TConfig(action: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   level: Short = 0) {
  def actionAndFormat = name(action) + "_" + name(format)

  private def name(s: Symbol): String = Option(s).map(_.name).getOrElse("")
}

sealed case class RStyle(it: Boolean) extends PartialFunction[Boolean, RStyle] {
  override def isDefinedAt(x: Boolean) = x == it

  override def apply(v1: Boolean) = this

  override def toString(): String = s"RStyle($it)"
}

object RStream extends RStyle(true)

object RAll extends RStyle(false)

object RStyle {
  def apply: Boolean => RStyle = RStream orElse RAll
}

sealed case class WStyle(it: Boolean) extends PartialFunction[Boolean, WStyle] {
  override def isDefinedAt(x: Boolean) = x == it

  override def apply(v1: Boolean) = this

  override def toString(): String = s"WStyle($it)"
}

object WRaw extends WStyle(false)

object WPretty extends WStyle(true)

object WStyle {
  def apply: Boolean => WStyle = WRaw orElse WPretty
}

sealed trait RPath

object Parse extends RPath

object Json extends RPath

case class Read(path: String) extends RPath

object RPath {
  def parse: RPath = Parse

  def json: RPath = Json

  def apply(path: String): RPath = Option(path).map(Read).getOrElse(Json)
}

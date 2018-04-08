package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

case class RWTConfig(read: RConfig = RConfig(),
                     write: WConfig = WConfig(),
                     translate: TConfig = TConfig(),
                     provider: Provider = Provider(""))

case class RConfig(provider: Provider = Provider(""),
                   format: Format = Format(""),
                   stream: RStyle = RStream,
                   path: RPath = null,
                   options: Set[Symbol] = Set())

case class WConfig(provider: Provider = Provider(""),
                   format: Format = Format(""),
                   style: WStyle = WPretty,
                   addEndLine: Boolean = true,
                   nullOptions: Boolean = true,
                   options: Set[Symbol] = Set())

case class TConfig(action: Symbol = Symbol(""),
                   format: Format = Format(""),
                   level: Short = 0) {
  def actionAndFormat: String = name(action) + "_" + name(format.s)

  private def name(s: Symbol): String = Option(s).map(_.name).getOrElse("")
}

case class Provider(s: Symbol) {
  def this(name: String) = this(Symbol(name))

  def startsWith(other: Provider): Boolean = name.startsWith(other.name)

  def name: String = s.name
}

case object Provider {
  @JsonCreator
  def apply(name: String): Provider = Provider(Symbol(name))
}

case class Format(s: Symbol) {
  def startsWith(other: Format): Boolean = name.startsWith(other.name)

  def name: String = s.name
}

case object Format {
  @JsonCreator
  def apply(name: String): Format = Format(Symbol(name))
}

sealed case class RStyle(it: Boolean) extends PartialFunction[Boolean, RStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): RStyle = this

  override def toString(): String = s"RStyle($it)"
}

object RStream extends RStyle(true)

object RAll extends RStyle(false)

case object RStyle {
  type T = Boolean => RStyle

  def get: T = RStream orElse RAll

  @JsonCreator
  def create(it: Boolean): RStyle = get.apply(it)
}

sealed case class WStyle(it: Boolean) extends PartialFunction[Boolean, WStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): WStyle = this

  override def toString(): String = s"WStyle($it)"
}

object WRaw extends WStyle(false)

object WPretty extends WStyle(true)

case object WStyle {
  type T = Boolean => WStyle

  def get: T = WRaw orElse WPretty

  @JsonCreator
  def create(b: Boolean): WStyle = get.apply(b)
}

sealed trait RPath

case object Parse extends RPath

case object Json extends RPath

case class Read(path: String) extends RPath

object RPath {
  def parse: RPath = Parse

  def json: RPath = Json

  def apply(path: String): RPath = Option(path).map(Read).getOrElse(Json)
}

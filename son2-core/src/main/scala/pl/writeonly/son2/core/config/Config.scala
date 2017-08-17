package pl.writeonly.son2.core.config

case class Config(read: RConfig = RConfig(), write: WConfig = WConfig(), translate: TConfig = TConfig())

case class RConfig(format: Symbol = Symbol(""), stream: Boolean = true, query: Option[String] = Option.empty)

//case class WConfig(val format: Symbol = Symbol(""), val style: RStyle = Raw())
case class WConfig(format: Symbol = Symbol(""), style: Boolean = false, addEndLine: Boolean = true)

case class TConfig(action: Symbol = Symbol(""), format: Symbol = Symbol(""), level: Short = 0) {
  def actionAndFormat = name(action) + "_" + name(format)

  private def name(s: Symbol): String = if (s != null) s.name else ""
}

abstract class RStyle
case class Raw() extends RStyle
case class Pretty() extends RStyle



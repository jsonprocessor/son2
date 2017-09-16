package pl.writeonly.son2.core.config

case class Config(read: RConfig = RConfig(), write: WConfig = WConfig(), translate: TConfig = TConfig())

case class RConfig(
                    provider: Symbol = Symbol(""),
                    format: Symbol = Symbol(""),
                    stream: Boolean = true,
                    path: Option[String] = Option.empty,
                    options: Set[Symbol] = Set()
                  )

case class WConfig(
                    provider: Symbol = Symbol(""),
                    format: Symbol = Symbol(""),
                    style: Boolean = false,
                    addEndLine: Boolean = true,
                    gson: Set[Symbol] = Set()
                  )

case class TConfig(action: Symbol = Symbol(""), format: Symbol = Symbol(""), level: Short = 0) {
  def actionAndFormat = name(action) + "_" + name(format)

  private def name(s: Symbol): String = if (s != null) s.name else ""
}

abstract class RStyle

case class Raw() extends RStyle

case class Pretty() extends RStyle



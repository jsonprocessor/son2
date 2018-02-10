package pl.writeonly.son2.core.config

case class Config(read: RConfig = RConfig(),
                  write: WConfig = WConfig(),
                  translate: TConfig = TConfig())

case class RConfig(provider: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   stream: Boolean = true,
                   path: RPath = RPath.json,
                   options: Set[Symbol] = Set())

case class WConfig(provider: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   style: Boolean = false,
                   addEndLine: Boolean = true,
                   gson: Set[Symbol] = Set())

case class TConfig(action: Symbol = Symbol(""),
                   format: Symbol = Symbol(""),
                   level: Short = 0) {
  def actionAndFormat = name(action) + "_" + name(format)

  private def name(s: Symbol): String = Option(s).map(_.name).getOrElse("")
}

abstract class RStyle

object Raw extends RStyle

object Pretty extends RStyle

abstract class RPath

object Parse extends RPath

object Json extends RPath

case class Read(path: String) extends RPath

object RPath {
  def parse: RPath = Parse
  def json: RPath = Json
  def apply(path: String): RPath = Option(path).map(Read).getOrElse(Json)
}

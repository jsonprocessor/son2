package pl.writeonly.son2.apis.config

case class RWTConfig(read: RConfig = RConfig(),
                     write: WConfig = WConfig(),
                     translate: TConfig = TConfig(),
                     provider: ProviderType = ProviderType(""),
                     action: Action = Action(""))

case class RConfig(provider: ProviderType = ProviderType(""),
                   format: Format = Format(""),
                   stream: RStyle = RStream,
                   path: RPath = null,
                   options: Set[Symbol] = Set())

case class WConfig(provider: ProviderType = ProviderType(""),
                   format: Format = Format(""),
                   style: WStyle = WPretty,
                   addEndLine: Boolean = true,
                   nullOptions: Boolean = true,
                   options: Set[Symbol] = Set())

case class TConfig(action: Action = Action(""),
                   format: Format = Format(""),
                   level: Short = 0) {
  def actionAndFormat: String = name(action.s) + "_" + name(format.s)

  private def name(s: Symbol): String = Option(s).map(_.name).getOrElse("")
}

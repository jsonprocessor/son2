package pl.writeonly.son2.core.config

case class TranslateConfig(action: Symbol = Symbol(""), format: Symbol = Symbol("")) {
  def actionAndFormat = name(action) + "_" + name(format)

  private def name(s: Symbol): String = if (s != null) s.name else ""
}

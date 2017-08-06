package pl.writeonly.son2.core.config

case class Config(
                   val read: Symbol = Symbol(""),
                   val stream: Boolean = true,
                   val write: Symbol = Symbol(""),
                   val pretty: Boolean = false,
                   translate: TranslateConfig = TranslateConfig()
                 )

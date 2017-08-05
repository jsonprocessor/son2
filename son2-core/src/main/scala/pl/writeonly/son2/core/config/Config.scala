package pl.writeonly.son2.core.config

case class Config(
                   val input: String = "",
                   val stream: Boolean = true,
                   val output: String = "",
                   val pretty: Boolean = false,
                   translate: TranslateConfig = TranslateConfig()
                 )

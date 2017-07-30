package pl.writeonly.son2.main

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.{Core, Params, Piper}
import pl.writeonly.son2.core.providers.{Provider, Provider2}
import pl.writeonly.son2.jack.chain.ChainReaderJack

class Mainer(params: Params, args: Array[String]) extends Core(params, args) {

  def provider(s: String): Either[Option[String], Provider] = Providers.provider(s)
  override def left(params: Params, format: Option[String]):Unit = new Resourcer(params).left(format)


}

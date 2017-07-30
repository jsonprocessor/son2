package pl.writeonly.son2.main

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainReaderJack

object Providers {

  def provider(s: String): Either[Option[String], Provider] = configOpt(s)
    .map(c => Chainer.provider(c))
    .map(p => Right(p))
    .getOrElse(Left(Option(s)))

  def configOpt(s:String) :Option[Config] = Chainer.configOpt(s) match {
    case c : Some[Config] => c
    case None => new ChainReaderJack().configOpt(s)
  }
}

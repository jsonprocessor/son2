package pl.writeonly.son2.main

import pl.writeonly.son2.core.chain.ChainNotationCreator
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.{ChainNotationPairJack, ChainReaderJack}
import pl.writeonly.son2.path.chain.ChainNotationPairPath

class CreatorProviderOrNot {

  def provider(s: String): Either[Option[String], Provider] = configOpt(s)
    .map(c => chainNotationCreator.provider(c))
    .map(p => Right(p))
    .getOrElse(Left(Option(s)))

  def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
    case None => new ChainReaderJack().configOpt(s)
  }

  val chainNotationCreator = new ChainNotationCreator(
    new ChainNotationPairPath(true).get
      orElse
      new ChainNotationPairJack(true).get
  )
}

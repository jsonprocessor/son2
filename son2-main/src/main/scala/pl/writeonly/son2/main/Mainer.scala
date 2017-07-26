package pl.writeonly.son2.main

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainReaderJack

class Mainer(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => provider(args(0).toLowerCase)
  }

  def provider(s: String): Either[Option[String], Provider] = configOpt(s)
    .map(c => Chainer.provider(c))
    .map(p => Right(p))
    .getOrElse(Left(Option(s)))

  def configOpt(s:String) :Option[Config] = Chainer.configOpt(s) match {
    case c : Some[Config] => c
//    case None => new ChainReaderJack().configOpt(s)
    case None => None
  }

}

package pl.writeonly.son2.main

import com.fasterxml.jackson.databind.JsonNode
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

  def provider(s: String): Either[Option[String], Provider] = Chainer.lift(s)
    .map(p => Right(p))
    .getOrElse(Left(Option(s)))

  def a(s:String) = new ChainReaderJack().get.lift(s).map(a => ChainReaderJack.config(a.asInstanceOf[JsonNode]))


  def b(s:String) = new ChainReaderJack().config(s)

}

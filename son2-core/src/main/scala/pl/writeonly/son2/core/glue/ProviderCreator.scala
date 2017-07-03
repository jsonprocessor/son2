package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.chain.ChainNotationPair
import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception.catching

abstract class ProviderCreator(c: Config) {
  def r: ChainNotationPair

  def w: ChainNotationPair

  def apply(): Either[Option[String], Provider] = catching(classOf[Exception])
    .either(ProviderCreator.provider(c, r, w)) match {
    case Right(r) => Right(r)
    case Left(l) => Left(Option(c.o))
  }

  def apply2(): Option[Provider] = catching(classOf[Exception])
    .opt(ProviderCreator.provider(c, r, w))

}

object ProviderCreator {
  def provider(
                c: Config,
                r: ChainNotationPair,
                w: ChainNotationPair
              ) = new Provider(c, r.apply(c.i).get.r, w.apply(c.o).get.w)
}


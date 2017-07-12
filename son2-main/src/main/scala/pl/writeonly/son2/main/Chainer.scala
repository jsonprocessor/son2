package pl.writeonly.son2.main

import pl.writeonly.son2.core.notation.{Config, NotationPair, NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.path.chain.ChainNotationPairPath

object Chainer {
  def chain(s:String) : Option[Provider] = chain(false)
    .lift(s).map(t => t.c)
    .map(f => f(s))
    .map(provider)

  def chain(p : Boolean) : PartialFunction[String, NotationPair] = (
    new ChainNotationPairPath(p).get
      orElse
      new ChainNotationPairJack(p).get
    )

  def provider(c : Config) = new Provider(c, input(c), output(c))

  def input(c :Config):NotationReader = chain(c.p).lift(c.i).map(f => f.r).get

  def output(c :Config):NotationWriter = chain(c.p).lift(c.o).map(f => f.w).get
}

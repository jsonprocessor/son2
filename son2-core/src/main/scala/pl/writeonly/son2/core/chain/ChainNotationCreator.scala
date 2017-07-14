package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.notation.{Config, NotationPair, NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider

class ChainNotationCreator(chain : PartialFunction[String, NotationPair] ) {
  def chain(s:String) : Option[Provider] = chain
    .lift(s).map(t => t.c)
    .map(f => f(s))
    .map(provider)

  def provider(c : Config) = new Provider(c, input(c), output(c))

  def input(c :Config):NotationReader = chain.lift(c.i).map(f => f.r).get

  def output(c :Config):NotationWriter = chain.lift(c.o).map(f => f.w).get
}

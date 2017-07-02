package pl.writeonly.son2.core.formats.matchers

import pl.writeonly.son2.core.notation.{NotationPair}

trait ChainCreator extends MatcherFormat[NotationPair]{
  def apply(s:String) : Option[NotationPair] = get.lift(s)
  def get : PartialFunction[String, NotationPair]
}

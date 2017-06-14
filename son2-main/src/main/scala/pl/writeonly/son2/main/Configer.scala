package pl.writeonly.son2.main

import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.formats.matchers.MatcherFormatPath

object Configer {
  def apply(arg : String) = arg match {
    case s if new MatcherFormatPath().predicate(s) => ConfigPath(i=s)
    case s => ConfigJack(o=s)
  }

  def provider(arg : String) = arg match {
    case s if new MatcherFormatPath().predicate(s) => ConfigPath(i=s)
    case s => ConfigJack(o=s)
  }

}

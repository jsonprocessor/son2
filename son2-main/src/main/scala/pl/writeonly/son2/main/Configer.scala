package pl.writeonly.son2.main

import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.creators.PartialCreatorPath

object Configer {
  def apply(arg: String) = arg match {
    case s if new PartialCreatorPath().isDefinedAt(s) => ConfigPath(i = s)
    case s => ConfigJack(o = s)
  }

  def provider(arg: String) = arg match {
    case s if new PartialCreatorPath().isDefinedAt(s) => ConfigPath(i = s)
    case s => ConfigJack(o = s)
  }

}

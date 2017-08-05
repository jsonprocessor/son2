package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.NotationTranslator

class Provider1(c: Config, t: NotationTranslator) extends Provider2(c, t, t)

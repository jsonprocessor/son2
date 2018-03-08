package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.config.RWTConfig
import pl.writeonly.son2.core.notation.NotationTranslator

class Converter1(c: RWTConfig, t: NotationTranslator)
    extends Converter2(c, t, t)

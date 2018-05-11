package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.config.RWTConfig
import pl.writeonly.son2.apis.notation.NotationTranslator

class Converter1(c: RWTConfig, t: NotationTranslator)
    extends Converter2(c, t, t)

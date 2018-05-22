package pl.writeonly.scallions.apis.converters

import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.notation.NotationTranslator

class Converter1(c: RWTConfig, t: NotationTranslator)
    extends Converter2(c, t, t)

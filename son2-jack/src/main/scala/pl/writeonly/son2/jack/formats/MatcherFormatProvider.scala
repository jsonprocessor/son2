package pl.writeonly.son2.jack.formats

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.creators.CreatorFormatProvider
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatStartsWith
import pl.writeonly.son2.jack.providers._

class MatcherFormatProvider(c: Config) extends MatcherFormatStartsWith[ProviderJack](new CreatorFormatProvider(c)) {

  def apply(): Either[Option[String], ProviderJack] = apply(c.o)
}

object MatcherFormatProvider {
  def apply(o: String): ProviderJack = apply(Config(o = o))

  def apply(config: Config): ProviderJack = either(config)
    .right
    .get

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def either(config: Config): Either[Option[String], ProviderJack] = new MatcherFormatProvider(config)
    .apply()

  //either
}

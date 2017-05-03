package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.formats.creators.CreatorFormatProvider
import pl.writeonly.son2.core.formats.matchers.MatcherFormatStartsWith
import pl.writeonly.son2.core.providers._

class MatcherFormatProvider(c: Config) extends MatcherFormatStartsWith[Provider](new CreatorFormatProvider(c)) {

  def apply(): Either[Option[String], Provider] = apply(c.o)
}

object MatcherFormatProvider {
  def apply(o: String): Provider = apply(Config(o = o))

  def apply(config: Config): Provider = either(config)
    .right
    .get

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def either(config: Config): Either[Option[String], Provider] = new MatcherFormatProvider(config)
    .apply()

//either
}

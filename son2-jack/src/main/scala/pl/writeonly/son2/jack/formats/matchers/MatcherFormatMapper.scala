package pl.writeonly.son2.jack.formats.matchers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.creators.CreatorFormatMapper
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatStartsWith

class MatcherFormatMapper
  extends MatcherFormat[ObjectMapper](new PredicateFormatStartsWith, new CreatorFormatMapper) {

}

object MatcherFormatMapper {
  def apply(config: Config): ObjectMapper = apply(config.i)

  def apply(i: String): ObjectMapper = new MatcherFormatMapper()
    .apply(i)
    .right
    .get
}
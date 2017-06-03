package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatStartsWith

class MatcherFormatStartsWith[F](c: CreatorFormat[F])
  extends MatcherFormat[F](new PredicateFormatStartsWith(),c) {

}

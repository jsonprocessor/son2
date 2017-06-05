package pl.writeonly.son2.jack.formats.matchers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatIsDefine

class MatcherFormatIsDefine(c: CreatorFormat[ObjectMapper])
  extends MatcherFormatJack[ObjectMapper](new PredicateFormatIsDefine(c), c) {

}

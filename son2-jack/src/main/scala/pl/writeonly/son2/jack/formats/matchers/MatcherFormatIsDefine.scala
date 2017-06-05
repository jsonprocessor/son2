package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatIsDefine
import pl.writeonly.son2.jack.notation.NotationReaderJack

class MatcherFormatIsDefine(c: CreatorFormat[NotationReaderJack])
  extends MatcherFormatJack[NotationReaderJack](new PredicateFormatIsDefine(c), c) {

}

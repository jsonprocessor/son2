package pl.writeonly.son2.jack.formats.matchers

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.jack.formats.creators.CreatorFormatMapper

class MatcherFormatParser
  extends MatcherFormatIsDefine(new CreatorFormatMapper) {

  def parse(s: String): JsonNode = apply(s)
    .right
    .get
    .readTree(s)

}


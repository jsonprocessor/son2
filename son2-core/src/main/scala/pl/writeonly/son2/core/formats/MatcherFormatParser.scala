package pl.writeonly.son2.core.formats

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.formats.creators.CreatorFormatMapper
import pl.writeonly.son2.core.formats.matchers.MatcherFormatIsDefine

class MatcherFormatParser extends MatcherFormatIsDefine(new CreatorFormatMapper) {

  def parse(s: String): JsonNode = apply(s)
    .right
    .get
    .readTree(s)

}


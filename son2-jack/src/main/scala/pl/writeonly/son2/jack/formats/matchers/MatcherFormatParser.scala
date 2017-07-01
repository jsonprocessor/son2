package pl.writeonly.son2.jack.formats.matchers

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.jack.formats.creators.CreatorFormatReader

class MatcherFormatParser
  extends MatcherFormatIsDefine(new CreatorFormatReader) {

  def parse(s: String): JsonNode = apply(s)
    .get
    .apply(s)

}


package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.TapestryJsonProvider
import com.jayway.jsonpath.spi.mapper.TapestryMappingProvider
import pl.writeonly.son2.path.core.FormatsPath

case class NotationCaseTapestry()
  extends NotationCaseProvider(FormatsPath.TAPESTRY, new TapestryJsonProvider, new TapestryMappingProvider)

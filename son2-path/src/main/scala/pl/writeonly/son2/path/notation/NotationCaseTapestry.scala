package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.TapestryJsonProvider
import com.jayway.jsonpath.spi.mapper.TapestryMappingProvider
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.defaults.DefaultsPath

case class NotationCaseTapestry()
  extends NotationCaseProvider(FormatsPath.TAPESTRY, c => new DefaultsTapesty(c))


class DefaultsTapesty(c:RConfig)
  extends DefaultsPath(c, new TapestryJsonProvider(), new TapestryMappingProvider())



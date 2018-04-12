package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.TapestryJsonProvider
import com.jayway.jsonpath.spi.mapper.TapestryMappingProvider
import pl.writeonly.son2.apis.config.{MetaImpl, RConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseTapestry()
    extends NotationCaseProvider(
      MetaImpl(ProvidersPath.TAPESTRY, Formats.OBJECT),
      c => new DefaultsTapesty(c)
    )

class DefaultsTapesty(c: RConfig)
    extends DefaultsPath(
      c,
      new TapestryJsonProvider(),
      new TapestryMappingProvider()
    )

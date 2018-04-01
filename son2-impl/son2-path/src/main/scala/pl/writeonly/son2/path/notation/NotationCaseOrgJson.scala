package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider
import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseOrgJson()
    extends NotationCaseProvider(ProvidersPath.ORG, c => new DefaultsOrgJson(c))

class DefaultsOrgJson(c: RConfig)
    extends DefaultsPath(
      c,
      new JsonOrgJsonProvider(),
      new JsonOrgMappingProvider()
    )

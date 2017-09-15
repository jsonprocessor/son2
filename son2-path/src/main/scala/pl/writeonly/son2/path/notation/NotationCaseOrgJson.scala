package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.defaults.DefaultsPath

case class NotationCaseOrgJson()
  extends  NotationCaseProvider(FormatsPath.ORG, c => new DefaultsOrgJson(c))

class DefaultsOrgJson(c:RConfig)
  extends DefaultsPath(c, new JsonOrgJsonProvider(), new JsonOrgMappingProvider())

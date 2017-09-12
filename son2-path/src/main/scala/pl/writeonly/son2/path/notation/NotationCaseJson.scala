package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider
import pl.writeonly.son2.path.core.FormatsPath

case class NotationCaseJson()
  extends  NotationCaseProvider(FormatsPath.ORG, new JsonOrgJsonProvider())

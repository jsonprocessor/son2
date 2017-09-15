package pl.writeonly.son2.path.notation

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.{DefaultsPath, FormatsPath}


case class NotationCaseJackson()
  extends NotationCasePath(FormatsPath.JACKSON, null, null)


case class NotationCaseNode()
  extends NotationCasePath(FormatsPath.JACKSON_NODE, null, null)


class DefaultsJackson(c: RConfig, objectMapper: ObjectMapper)
  extends DefaultsPath(c, new JacksonJsonNodeJsonProvider(objectMapper), new JacksonMappingProvider(objectMapper)) {
  def this(c: RConfig) = this(c, new ObjectMapper())
}



package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JettisonProvider
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.{ DefaultsPath, ProvidersPath }

case class NotationCaseJettison()
  extends NotationCaseProvider(
    ProvidersPath.JETTISON,
    c => new DefaultsJettison(c))

class DefaultsJettison(c: RConfig)
  extends DefaultsPath(c, new JettisonProvider(), null)

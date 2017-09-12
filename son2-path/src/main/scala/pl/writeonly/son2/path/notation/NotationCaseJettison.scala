package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JettisonProvider
import pl.writeonly.son2.path.core.FormatsPath

case class NotationCaseJettison()
  extends NotationCaseProvider(FormatsPath.JETTISON, new JettisonProvider())

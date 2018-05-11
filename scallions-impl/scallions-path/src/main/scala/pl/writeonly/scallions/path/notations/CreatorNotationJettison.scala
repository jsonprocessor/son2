package pl.writeonly.scallions.path.notations

import com.jayway.jsonpath.spi.json.JettisonProvider
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.{CreatorNotationProvider, IllegalStateMappingProvider}
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.path.notation.{CreatorNotationProvider, IllegalStateMappingProvider}

object CreatorNotationJettison extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.JETTISON, Formats.OBJECT)

  override def jsonProvider = new JettisonProvider

  override def mappingProvider = new IllegalStateMappingProvider

}

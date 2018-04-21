package pl.writeonly.son2.path.notations

import com.jayway.jsonpath.spi.json.JettisonProvider
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.{
  CreatorNotationProvider,
  IllegalStateMappingProvider
}

object CreatorNotationJettison extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.JETTISON, Formats.OBJECT)

  override def jsonProvider = new JettisonProvider

  override def mappingProvider = new IllegalStateMappingProvider

}

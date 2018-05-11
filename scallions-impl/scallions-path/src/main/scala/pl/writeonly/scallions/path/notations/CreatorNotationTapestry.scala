package pl.writeonly.scallions.path.notations

import com.jayway.jsonpath.spi.json.TapestryJsonProvider
import com.jayway.jsonpath.spi.mapper.TapestryMappingProvider
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.CreatorNotationProvider
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.CreatorNotationProvider

object CreatorNotationTapestry extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.TAPESTRY, Formats.OBJECT)

  override def jsonProvider = new TapestryJsonProvider()

  override def mappingProvider = new TapestryMappingProvider()
}

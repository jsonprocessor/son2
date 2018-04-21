package pl.writeonly.son2.path.notations

import com.jayway.jsonpath.spi.json.TapestryJsonProvider
import com.jayway.jsonpath.spi.mapper.TapestryMappingProvider
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.CreatorNotationProvider

object CreatorNotationTapestry extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.TAPESTRY, Formats.OBJECT)

  override def jsonProvider = new TapestryJsonProvider()

  override def mappingProvider = new TapestryMappingProvider()
}

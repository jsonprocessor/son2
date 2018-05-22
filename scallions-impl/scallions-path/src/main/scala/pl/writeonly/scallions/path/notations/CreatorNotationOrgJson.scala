package pl.writeonly.scallions.path.notations

import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.CreatorNotationProvider

object CreatorNotationOrgJson extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.ORG, Formats.OBJECT)

  override def jsonProvider = new JsonOrgJsonProvider()

  override def mappingProvider = new JsonOrgMappingProvider()
}

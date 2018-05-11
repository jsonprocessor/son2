package pl.writeonly.son2.path.notations

import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.CreatorNotationProvider

object CreatorNotationOrgJson extends CreatorNotationProvider {

  override val meta = Meta(ProvidersPath.ORG, Formats.OBJECT)

  override def jsonProvider = new JsonOrgJsonProvider()

  override def mappingProvider = new JsonOrgMappingProvider()
}

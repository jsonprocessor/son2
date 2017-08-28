package pl.writeonly.son2.path.providers

import java.util

import com.jayway.jsonpath.spi.json.JsonProvider
import com.jayway.jsonpath.spi.mapper.MappingProvider
import com.jayway.jsonpath.{Configuration, Option}

class ProviderPair(json: JsonProvider, mapping: MappingProvider) extends Configuration.Defaults {
  override def jsonProvider(): JsonProvider = json

  override def mappingProvider(): MappingProvider = mapping

  override def options(): util.Set[Option] = util.EnumSet.noneOf(classOf[Option]);

}

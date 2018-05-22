package pl.writeonly.scallions.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import com.jayway.jsonpath.spi.mapper.MappingProvider
import pl.writeonly.scallions.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.scallions.apis.notation.NotationWriter
import pl.writeonly.scallions.path.core.DefaultsPath

trait CreatorNotation {
  def meta: Meta

  def defaultsPath(c: RConfig): DefaultsPath =
    new DefaultsPath(c, jsonProvider, mappingProvider)

  def reader(c: RConfig): NotationReaderPath

  def writer(c: WConfig): NotationWriter

  def apply() = new NotationCasePath(meta, reader, writer)

  def jsonProvider: JsonProvider

  def mappingProvider: MappingProvider

}

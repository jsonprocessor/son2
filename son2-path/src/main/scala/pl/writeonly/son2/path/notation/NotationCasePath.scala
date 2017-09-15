package pl.writeonly.son2.path.notation

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath

abstract class NotationCasePath(
                     val format: Symbol,
                     val reader: RConfig => NotationReaderPath,
                     val writer: WConfig => NotationWriter

)






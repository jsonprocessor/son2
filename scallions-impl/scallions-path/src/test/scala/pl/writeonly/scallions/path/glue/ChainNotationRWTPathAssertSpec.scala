package pl.writeonly.scallions.path.glue

import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.apis.config.RConfig
import pl.writeonly.scallions.path.core.{DefaultsPath, ProvidersPath}
import pl.writeonly.scallions.path.notation.NotationReaderPath

class ChainNotationRWTPathAssertSpec extends WhiteAssertSpec {

  val chain = new ChainNotationRWTPath()
  val creatorReader = chain.r
  val tapestry = ProvidersPath.TAPESTRY
  "A creatorReader" when {
    "is apply with 'tapestry" should {
      val config = RConfig(provider = tapestry)
      "reader has class NotationReaderPath" in {
        assertResult(classOf[NotationReaderPath]) {
          val reader = creatorReader.apply(config)
          reader.getClass
        }
      }
      "defaults has class NotationReaderPath" in {
        assertResult(classOf[DefaultsPath]) {
          val reader = creatorReader.apply(config)
          val readerPath = reader.asInstanceOf[NotationReaderPath]
          val defaults = readerPath.defaults
          defaults.getClass
        }
      }
    }
  }
}

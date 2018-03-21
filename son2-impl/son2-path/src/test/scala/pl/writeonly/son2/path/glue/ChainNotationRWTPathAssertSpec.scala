package pl.writeonly.son2.path.glue

import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.{DefaultsTapesty, NotationReaderPath}
import pl.writeonly.sons.specs.WhiteAssertSpec

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
        assertResult(classOf[DefaultsTapesty]) {
          val reader = creatorReader.apply(config)
          val readerPath = reader.asInstanceOf[NotationReaderPath]
          val defaults = readerPath.defaults
          defaults.getClass
        }
      }
    }
  }
}

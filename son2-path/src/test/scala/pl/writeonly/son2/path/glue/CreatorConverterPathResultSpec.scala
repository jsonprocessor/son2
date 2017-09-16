package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.util.Control.toConsumerAny
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.WhiteResultSpec

class CreatorConverterPathResultSpec extends WhiteResultSpec {

  val providerName = ProvidersPath.TAPESTRY.name
  val configer = new ChainNotationConfigPath().get
  val chain = new ChainNotationRWTPath
  val reader = chain.r
  val writer = chain.w
  "A configer" when {
    "providerName is 'tapesrty" should {
      "return true" in {
        assertResult(true) {configer.isDefinedAt(providerName)}
      }
      "return 'tapestry" in {
        assertResult('tapestry) {configer.apply(providerName).read.provider}
      }
    }
  }
}

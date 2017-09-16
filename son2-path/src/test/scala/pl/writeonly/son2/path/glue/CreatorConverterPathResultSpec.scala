package pl.writeonly.son2.path.glue

import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.WhiteResultSpec

class CreatorConverterPathResultSpec extends WhiteResultSpec {

  val provider = ProvidersPath.TAPESTRY
  val providerName = provider.name
  val configer = new ChainNotationConfigPath().get
  val chain = new ChainNotationRWTPath
  val reader = chain.r
  val writer = chain.w
  "A configer" when {
    "providerName is 'tapesrty" should {
      "return true" in {
        assertResult(true) {
          configer.isDefinedAt(providerName)
        }
      }
      "return 'tapestry" in {
        assertResult(provider) {
          configer.apply(providerName).read.provider
        }
      }
    }
  }
  "A CreatorConverterPath " when {
    "provider is 'tapesrty" should {
      val a = CreatorConverterPath.apply(provider)
      "read.provider is 'tapesrty" in {
        assertResult(provider) {
          a.config.read.provider
        }
      }
      "write.provider is 'tapesrty" in {
        assertResult(provider) {
          a.config.write.provider
        }
      }
    }
  }

}

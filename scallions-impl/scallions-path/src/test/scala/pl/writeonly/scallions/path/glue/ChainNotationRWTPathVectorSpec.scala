package pl.writeonly.scallions.path.glue

import org.scalatest.Outcome
import pl.writeonly.scallions.apis.config.RConfig
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.path.core.ProvidersPath

class ChainNotationRWTPathVectorSpec extends GrayVectorSpec with Pipe {

  override type FixtureParam = ChainNotationRWTPath

  override protected def withFixture(test: OneArgTest): Outcome =
    new ChainNotationRWTPath |> test

  val providers = Table("format", ProvidersPath.ALL: _*)

  property("ChainNotationRWTPath.r") { chain =>
    forAll(providers) { (provider) =>
      val config = RConfig(provider = provider)
      val creatorReader = chain.r
      creatorReader.isDefinedAt(config) shouldBe true
      val reader = creatorReader.apply(config)
      reader.getClass
    }
  }

}

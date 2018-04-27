package pl.writeonly.son2.funs.liners

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.addons.pipe.Pipe

class LinerWithTryAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = LinerWithTry

  override protected def withFixture(test: OneArgTest): Outcome =
    new LinerWithTry(new ConverterFake) |> test

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in { liner =>
        liner.apply("")
      }
    }
  }

}

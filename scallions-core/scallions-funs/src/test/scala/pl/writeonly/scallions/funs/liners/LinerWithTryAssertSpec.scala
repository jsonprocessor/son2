package pl.writeonly.scallions.funs.liners

import org.scalatest.Outcome
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scalaops.specs.fixture.WhiteAssertSpec
import pl.writeonly.scallions.apis.converters.ConverterFake

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

package pl.writeonly.scallions.funs.liners

import org.scalatest.Outcome
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scalaops.specs.fixture.WhiteAssertSpec
import pl.writeonly.scallions.apis.converters.ConverterFake

class LinerOptAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = LinerOpt

  override protected def withFixture(test: OneArgTest): Outcome =
    new LinerOpt(new ConverterFake) |> test

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in { liner =>
        assertResult("\n")(liner.apply(""))
      }
    }
  }

}

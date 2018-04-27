package pl.writeonly.son2.funs.liners

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.addons.pipe.Pipe

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

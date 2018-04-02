package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config._
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

class ConfigOptRisonVectorSpec extends GrayVectorSpec with Pipe {

  override type FixtureParam = ConfigOptRison

  override protected def withFixture(test: OneArgTest) =
    new ConfigOptRison |> test

  val table = Table(
    ("in", "out"),
    (
      "",
      RWTConfig(
        RConfig(Provider('jackson), Format('json), RStyle(true), null, Set()),
        WConfig(
          Provider('jackson),
          Format('json),
          WStyle(true),
          true,
          true,
          Set()
        ),
        TConfig(null, null, 0),
        Provider('jackson)
      )
    )
  )

  property("creatorOr create symbolPair") { convert =>
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }

}

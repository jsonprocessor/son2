package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.hocon.ConfigOptHocon
import pl.writeonly.son2.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.sons.specs.fixture.GrayVectorSpec
import pl.writeonly.sons.utils.ops.Pipe

class ConfigOptHoconVectorSpec extends GrayVectorSpec with Pipe {

  override type FixtureParam = ConfigOptHocon

  override protected def withFixture(test: OneArgTest) =
    new ConfigOptHocon |> test

  val table = Table(
    ("in", "out"),
    (
      "",
      RWTConfig(
        RConfig(Provider('jackson), Format('object), RStyle(true), null, Set()),
        WConfig(
          Provider('jackson),
          Format('object),
          WStyle(true),
          true,
          true,
          Set()
        ),
        TConfig(null, Format(""), 0),
        Provider('jackson)
      )
    ),
    ("", ConfigJack(FormatsJack.OBJECT))
  )

  property("creatorOr create symbolPair") { convert =>
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }
}

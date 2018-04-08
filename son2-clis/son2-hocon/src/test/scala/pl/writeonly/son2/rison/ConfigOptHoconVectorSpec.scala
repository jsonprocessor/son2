package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.hocon.ConfigOptHocon
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.json.core.ConfigJson
import pl.writeonly.son2.path.core.{ConfigPath, ProvidersPath}
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
        RConfig(
          ProvidersPath.JACKSON,
          Formats.OBJECT,
          RStyle(true),
          null,
          Set()
        ),
        WConfig(
          ProvidersPath.JACKSON,
          Formats.OBJECT,
          WStyle(true),
          true,
          true,
          Set()
        ),
        TConfig(null, Format(""), 0),
        ProvidersPath.JACKSON
      )
    ),
    ("", ConfigJack(Formats.OBJECT)),
    (
      "read={provider=smart,format=\"\"},write={provider=smart,format=\"\",style=false}",
      ConfigPath(q = null)
    ),
    (
      "read={provider=gson},write={provider=gson},provider=gson",
      ConfigJson(q = null)
    )
  )

  property("creatorOr create symbolPair") { convert =>
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }
}

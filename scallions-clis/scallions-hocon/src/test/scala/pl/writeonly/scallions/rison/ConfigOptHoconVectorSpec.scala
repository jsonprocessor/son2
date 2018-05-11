package pl.writeonly.scallions.rison

import pl.writeonly.scallions.apis.config._
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.path.core.ConfigPath
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.apis.config.{Format, WStyle}
import pl.writeonly.scallions.hocon.ConfigOptHocon
import pl.writeonly.scallions.jack.core.ConfigJack
import pl.writeonly.scallions.json.core.ConfigJson
import pl.writeonly.scallions.path.core.{ConfigPath, ProvidersPath}

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

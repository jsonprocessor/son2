package pl.writeonly.scallions.rison

import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scalaops.specs.fixture.GrayVectorSpec
import pl.writeonly.scallions.apis.config.{Format, WStyle, _}
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.jack.core.{ConfigJack, FormatsJack, ProvidersJack}
import pl.writeonly.scallions.json.core.ConfigJson
import pl.writeonly.scallions.path.core.ConfigPath

class ConfigOptRisonVectorSpec extends GrayVectorSpec with Pipe {

  override type FixtureParam = ConfigOptRison

  override protected def withFixture(test: OneArgTest) =
    new ConfigOptRison |> test

  val table = Table(
    ("in", "out"),
    (
      "",
      RWTConfig(
        RConfig(
          ProvidersJack.JACKSON,
          Formats.OBJECT,
          RStyle(true),
          null,
          Set()
        ),
        WConfig(
          ProvidersJack.JACKSON,
          Formats.OBJECT,
          WStyle(true),
          true,
          true,
          Set()
        ),
        TConfig(null, Format(""), 0),
        ProvidersJack.JACKSON
      )
    ),
    ("", ConfigJack(FormatsJack.OBJECT)),
    (
      "read:(provider:smart,format:''),write:(provider:smart,format:'',style:false)",
      ConfigPath(q = null)
    ),
    (
      "read:(provider:gson),write:(provider:gson),provider:gson",
      ConfigJson(q = null)
    )
  )

  property("creatorOr create symbolPair") { convert =>
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }

}

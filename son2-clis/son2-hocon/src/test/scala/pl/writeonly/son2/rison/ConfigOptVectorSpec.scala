package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config.RWTConfig
import pl.writeonly.son2.hocon.ConfigOpt
import pl.writeonly.sons.specs.GrayVectorSpec

class ConfigOptVectorSpec extends GrayVectorSpec {
  val table = Table(
    ("in", "out"),
    ("", RWTConfig(null, null, null))
  )

  val convert = ConfigOpt
  property("creatorOr create symbolPair") {
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }
}

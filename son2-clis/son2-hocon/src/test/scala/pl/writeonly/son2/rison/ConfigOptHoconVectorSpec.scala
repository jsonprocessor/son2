package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config.{RConfig, RWTConfig, TConfig, WConfig}
import pl.writeonly.son2.hocon.ConfigOptHocon
import pl.writeonly.sons.specs.GrayVectorSpec

class ConfigOptHoconVectorSpec extends GrayVectorSpec {
  val table = Table(
    ("in", "out"),
    ("",
     RWTConfig(RConfig(null, null, null, null, Set()),
               WConfig(null, null, null, false, false, Set()),
               TConfig(null, null, 0)))
  )

  val convert = ConfigOptHocon
  property("creatorOr create symbolPair") {
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }
}

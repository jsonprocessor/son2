package pl.writeonly.son2.rison

import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.hocon.ConfigOptHocon
import pl.writeonly.sons.specs.GrayVectorSpec

class ConfigOptHoconVectorSpec extends GrayVectorSpec {
  val table = Table(
    ("in", "out"),
    ("",
     RWTConfig(
       RConfig(Provider('jackson), Format('json), RStyle(true), null, Set()),
       WConfig(Provider('jackson),
               Format('json),
               WStyle(true),
               true,
               true,
               Set()),
       TConfig(null, null, 0),
       Provider('jackson)
     ))
  )

  val convert = new ConfigOptHocon
  property("creatorOr create symbolPair") {
    forAll(table) { (in, out) =>
      convert config in shouldBe out
    }
  }
}

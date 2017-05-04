package pl.writeonly.son2.core.specs

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.TableDrivenPropertyChecks

abstract class PropMatchers extends PropSpec with TableDrivenPropertyChecks with Matchers {

}

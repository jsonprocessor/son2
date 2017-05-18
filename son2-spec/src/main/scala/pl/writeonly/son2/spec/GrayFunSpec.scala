package pl.writeonly.son2.spec

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

abstract class GrayFunSpec extends FunSpec with TableDrivenPropertyChecks with Matchers {

}

package pl.writeonly.son2.core

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FunSpec, GivenWhenThen, Matchers, PropSpec}
import pl.writeonly.son2.core.providers.{Provider, ProviderYaml}

class LinerYamlProp extends PropSpec with TableDrivenPropertyChecks with Matchers with GivenWhenThen {

  val provider: Provider = new ProviderYaml()

  val toSuccess = Table(
    ("in", "out"),
    ("0", "--- 0\n"),
    ("\"a\"", "--- \"a\"\n"),
    ("[]", "--- []\n"),
    ("[0]", "---\n- 0\n"),
    ("[0,1]", "---\n- 0\n- 1\n"),
    ("{}", "--- {}\n"),
    ("{\"a\":0}", "---\na: 0\n"),
    ("{\"a\":0, \"b\":1}", "---\na: 0\nb: 1\n"),
    ("[{}]", "---\n- {}\n"),
    ("{\"a\":[]}", "---\na: []\n")
  )

  property("convert son to yaml") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }
}

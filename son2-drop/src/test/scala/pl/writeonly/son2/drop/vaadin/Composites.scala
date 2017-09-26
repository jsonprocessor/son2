package pl.writeonly.son2.drop.vaadin

import com.vaadin.ui.CustomComponent
import pl.writeonly.son2.drop.vaadin.complexes.ComplexRWHorizontal
import pl.writeonly.son2.spec.GrayVectorSpec

class Composites extends GrayVectorSpec {

  val composites = Table("composites",
    classOf[ComplexRWHorizontal]
  )
  property("A new instance composite by clazz") {
    forAll(composites) { (clazz) =>
      val composite : CustomComponent = clazz.newInstance()
    }
  }
}

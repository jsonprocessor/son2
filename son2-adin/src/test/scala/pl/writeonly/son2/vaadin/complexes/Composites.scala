package pl.writeonly.son2.vaadin.complexes

import com.vaadin.ui.CustomComponent
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.vaadin.complexes.captioneds.{GsonOptionsComp, JackFormatsComp, PathComp, SmartComp}

class Composites extends GrayVectorSpec {

  val composites = Table("composites",
    classOf[ComplexRWHorizontal],
    classOf[ComplexRWVertical],
    classOf[GsonOptionsComp],
    classOf[JackFormatsComp],
    classOf[PathComp],
    classOf[PathOptionsComp],
    classOf[PathProviderComp],
    classOf[SmartComp],
    classOf[SmartFlagsComp],
    classOf[SmartOptionsComp]

  )
  property("A new instance composite by clazz") {
    forAll(composites) { (clazz) =>
      val composite : CustomComponent = clazz.newInstance()
      composite.getComponentCount
    }
  }
}

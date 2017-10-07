package pl.writeonly.son2.vaadin.ui

import com.vaadin.ui.UI
import pl.writeonly.son2.spec.GrayVectorSpec

class UIes extends GrayVectorSpec {

  val uies = Table("uies",
    classOf[UIComparator],
    classOf[UIConverter],
    classOf[UIDiff],
    classOf[UIFormatter],
    classOf[UIPatch],
    classOf[UIPath]
  )
  property("A new instance UI by clazz ") {
    forAll(uies) { (clazz) =>
      val ui: UI = clazz.newInstance()
    }
  }
}

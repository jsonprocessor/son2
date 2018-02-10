package pl.writeonly.son2.vaadin.ui

import pl.writeonly.son2.spec.GrayVectorSpec

class UITraits extends GrayVectorSpec {

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
      val ui: UITrait2 = clazz.newInstance()
      ui.componentsCenter.size should be > 0
      val center = ui.componentsCenter2
      center.inputs.size should be > 0
      val convert = center.convert
      convert.isEnabled should be(true)
      convert.click()
    }
  }
}

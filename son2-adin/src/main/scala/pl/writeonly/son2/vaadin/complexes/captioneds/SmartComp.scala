package pl.writeonly.son2.vaadin.complexes.captioneds

import pl.writeonly.son2.vaadin.complexes.hasselecteditems.SmartOptionsComp
import pl.writeonly.son2.vaadin.complexes.{ComplexWithCaption, SmartFlagsComp}
import pl.writeonly.son2.vaadin.util.UIUtil

class SmartComp extends ComplexWithCaption("Smart") {
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = PathComp.horizontalLayout(options, flags)
  set(layout)

}

object SmartComp extends UIUtil
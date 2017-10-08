package pl.writeonly.son2.vaadin.complexes.captioneds

import pl.writeonly.son2.vaadin.complexes.{ComplexWithCaption, SmartFlagsComp, SmartOptionsComp}
import pl.writeonly.son2.vaadin.util.UITrait


class SmartComp extends ComplexWithCaption("Smart") {
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = PathComp.horizontalLayout(options, flags)
  set(layout)

}

object SmartComp extends UITrait
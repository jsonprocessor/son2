package pl.writeonly.son2.vaadin.complexes

import pl.writeonly.son2.vaadin.util.UITrait


class SmartComp extends Complex {
  setCaption("Smart")
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = ComplexPath.horizontalLayout(options, flags)
  set(layout)

}

object SmartComp extends UITrait
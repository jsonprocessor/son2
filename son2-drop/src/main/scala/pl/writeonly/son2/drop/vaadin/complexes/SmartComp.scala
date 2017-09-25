package pl.writeonly.son2.drop.vaadin.complexes

import pl.writeonly.son2.drop.vaadin.util.UITrait


class SmartComp extends Complex {
  setCaption("Smart")
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = ComplexPath.horizontalLayout(options, flags)
  set(layout)

}

object SmartComp extends UITrait
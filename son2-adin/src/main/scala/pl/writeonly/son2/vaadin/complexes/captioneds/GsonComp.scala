package pl.writeonly.son2.vaadin.complexes.captioneds

import pl.writeonly.son2.vaadin.complexes.ComplexWithCaption
import pl.writeonly.son2.vaadin.complexes.hasselecteditems.GsonOptionsComp
import pl.writeonly.son2.vaadin.util.UITrait

class GsonComp extends ComplexWithCaption("Gson") {
  val options = new GsonOptionsComp()
  set(options)
}

object GsonComp extends UITrait

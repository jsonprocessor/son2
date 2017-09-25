package pl.writeonly.son2.drop.vaadin.complexes

import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class PathProviderComp extends Complex {
  private val component = PathProviderComp.apply
  set(component)

  def selectedItem = PathProviderComp.selectedItem(component).value
}

object PathProviderComp extends UITrait {
  private val smart = ItemSymbol('smart)
  private val items = Set(
    ItemSymbol('gson),
    ItemSymbol('jackson),
    ItemSymbol('jettison),
    ItemSymbol('org),
    smart,
    ItemSymbol('strict),
    ItemSymbol('tapestry)
  )

  private def apply = radioButtonGroup("Providers:", items, smart);
}

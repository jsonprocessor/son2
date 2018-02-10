package pl.writeonly.son2.vaadin.complexes.hasselecteditems

import pl.writeonly.son2.vaadin.complexes.{Complex, HasRadioButtonSelectedItem}
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

class PathProviderComp extends Complex with HasRadioButtonSelectedItem {
  private val component = PathProviderComp.apply
  set(component)

  def selectedItem = PathProviderComp.selectedItem(component).value
}

object PathProviderComp extends UIUtil {
  private val smart = ItemSymbol('smart)
  private val items = Set(
    ItemSymbol('gson),
    ItemSymbol('jackson),
    ItemSymbol('jettison),
    ItemSymbol('org),
    smart,
    ItemSymbol('strict),
    ItemSymbol('tapestry))

  private def apply = radioButtonGroup("Providers:", items, smart);
}

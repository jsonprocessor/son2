package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class ComplexPathProvider extends Complex {
  private val component = ComplexPathProvider.apply

  override def toComponent: Component = component

  def selectedItem = ComplexPathProvider.selectedItem(component).value
}

object ComplexPathProvider extends UITrait {
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

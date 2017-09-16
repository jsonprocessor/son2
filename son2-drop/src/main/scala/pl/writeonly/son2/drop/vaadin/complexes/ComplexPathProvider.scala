package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexPathProvider extends Complex {
  private val component = ComplexPathProvider.apply
  override def toComponent: Component = component
  override def components: List[Component] = List(toComponent)
  def selectedItem = ComplexPathProvider.selectedItem(component, ComplexPathProvider.mapping)
}

object ComplexPathProvider extends UITrait {
  val mapping = Map[String, Symbol](
    "Gson" -> 'gson,
    "Jackson" -> 'jackson,
    "Jettison" -> 'jettison,
    "Org" -> 'org,
    "Smart" -> 'smart,
    "Strict" -> 'strict,
    "Tapestry" -> 'tapestry
  )

  private def apply = radioButtonGroup("Providers:", mapping, "Smart");
}

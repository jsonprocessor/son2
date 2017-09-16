package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait

class CompositePathProvider extends Composite {
  private val component = CompositePathProvider.apply
  override def components: List[Component] = List(component)
  def selectedItem = CompositePathProvider.selectedItem(component, CompositePathProvider.mapping)
}

object CompositePathProvider extends UITrait {
  val mapping = Map[String, Symbol](
    "Gson" -> 'gson,
    "Jackson" -> 'jackson,
    "Jettison" -> 'jettison,
    "Org" -> 'org,
    "Smart" -> 'smart,
    "Strict" -> 'strict,
    "Tapestry" -> 'tapestry
  )

  private def apply = radioButtonGroup("Providers", mapping, "Smart");
}

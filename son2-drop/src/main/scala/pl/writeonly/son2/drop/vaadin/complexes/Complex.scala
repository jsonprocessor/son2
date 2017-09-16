package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component

trait Complex {
  def components: List[Component]
  def toComponent: Component

}

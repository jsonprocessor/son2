package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component

trait Composite {
  def components: List[Component]

}

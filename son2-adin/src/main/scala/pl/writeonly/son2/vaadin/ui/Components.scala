package pl.writeonly.son2.vaadin.ui

import com.vaadin.ui.Component

trait Components {
  val optionPanel : Component
  val inputs : List[Component]
  val convert: Component
  val output : Component
  def list : List[Component] = List(optionPanel) ++ inputs ++ List(convert, output)
}

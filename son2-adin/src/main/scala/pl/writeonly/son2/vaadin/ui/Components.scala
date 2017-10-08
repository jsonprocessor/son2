package pl.writeonly.son2.vaadin.ui

import com.vaadin.ui.{Button, Component, Label, Panel}

trait Components {
  val optionPanel : Panel
  val inputs : List[Component]
  val convert: Button
  val output : Label
  def list : List[Component] = List(optionPanel) ++ inputs ++ List(convert, output)
}

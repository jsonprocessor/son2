package pl.writeonly.son2.vaadin.ui

import com.vaadin.ui.{Button, Component, Label, Panel}
import pl.writeonly.son2.vaadin.util.UIUtil

trait Components extends UIUtil {
  val components: Seq[Component]
  val inputs: Seq[Component]
  val convert: Button
  val output: Label

  def optionsPanel(components: Seq[Component]): Panel = {
    val result = new Panel("Options", optionsHorizontalLayout(components))
    setWidth(result)
    result
  }

  def list: List[Component] = List(optionsPanel(components)) ++ inputs ++ List(convert, output)
}

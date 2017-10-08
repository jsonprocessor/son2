package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.vaadin.util.UITrait

@Title("json path")
@Theme("valo")
class UIDiff extends UITrait {
  override def componentsCenter: List[Component] = {
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val components: List[Component] = List(configLabel)

    val inputPatch = inputTextArea("json-patch")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(provider = Symbol(path))

      }
    })

    return List(optionsPanel(components), inputPatch, input, convert, output)
  }
}
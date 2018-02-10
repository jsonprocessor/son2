package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.path.core.ConfigPath

@Title("json path")
@Theme("valo")
class UIDiff extends UITrait2 {
  override def componentsCenter2: Components = new Components() {
    val configLabel = outputLabel
    val input = inputTextArea("Input json")
    val output = outputLabel

    val components: List[Component] = List(configLabel)

    val inputPatch = inputTextArea("json-patch")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(provider = Symbol(path))

      }
    })
    val optionPanel = optionsPanel(components)
    val inputs = List(inputPatch, input)

  }

}
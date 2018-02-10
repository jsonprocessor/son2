package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.vaadin.complexes.ComplexIO

@Title("json patch")
@Theme("valo")
class UIPatch extends UITrait2 {
  override def componentsCenter2: Components = new Components() {
    val configLabel = outputLabel
    val io = new ComplexIO

    val components: List[Component] = List(configLabel)

    val inputPatch = inputTextArea("json-patch")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(provider = Symbol(path))

      }
    })
    val inputs = List(inputPatch, io.input)
    val output = io.output
  }

}
package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.drop.vaadin.complexes.ComplexIO
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait}
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.glue.CreatorConverterPathMain

import scala.collection.JavaConverters._

@Title("json patch")
@Theme("valo")
class UIPatch extends UITrait {
  override def componentsCenter: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val io = new ComplexIO

    val components: List[Component] = List(checkBoxes, configLabel)

    val inputPatch = inputTextArea("json-patch")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(i = Symbol(path))

        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterPathMain(config), io.input, io.output, set)
      }
    })

    return List(optionsPanel(components), inputPatch, io.input, convert, io.output)
  }
}
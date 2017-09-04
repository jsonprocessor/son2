package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.drop.vaadin.util.Mappings
import pl.writeonly.son2.path.core.ConfigPath

import scala.collection.JavaConverters._
import pl.writeonly.son2.path.glue.CreatorConverterPath

@Title("json path")
@Theme("valo")
class UIPatch extends UITrait {

//  val providers = List("Jackson", "Json", "Gson", "Smart")

  override def components: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping, "Smart");
    val outputFormats = jacksonOutputFormat("JSON")
    val components: List[Component] = List(providerGroup, outputFormats, checkBoxes, configLabel)

    val inputPatch = inputTextArea("json-patch")


    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(i = Symbol(path))

        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterPath(config), input, output, set)

      }
    });

    return List(linkPanel, optionsPanel(components), inputPatch, input, convert, output)
  }
}
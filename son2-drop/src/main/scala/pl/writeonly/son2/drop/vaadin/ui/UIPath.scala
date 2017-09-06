package pl.writeonly.son2.drop.vaadin.ui

import com.google.common.collect.ImmutableList
import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait}
import pl.writeonly.son2.path.core.ConfigPath

import scala.collection.JavaConverters._
import pl.writeonly.son2.path.glue.CreatorConverterPath

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def components: List[Component] = {
    val read = readGroup
    val write = writeGroup
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping, "Smart");
    val outputFormats = jacksonOutputFormat("JSON")
    val components: List[Component] = List(providerGroup, outputFormats, read, write, checkBoxes, configLabel)

    val inputPath = inputTextField("json-path")


    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val config = ConfigPath(i = Symbol(path))

        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterPath(config), input, output, set)

      }
    });

    return List(linkPanel, optionsPanel(components), inputPath, input, convert, output)
  }
}
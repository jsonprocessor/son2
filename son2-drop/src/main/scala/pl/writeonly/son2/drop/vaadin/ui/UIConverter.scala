package pl.writeonly.son2.drop.vaadin.ui

import java.util.Optional

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.util.JavaFunctions._
import pl.writeonly.son2.drop.vaadin.util.{ComponentsRW, Mappings, TopMenu, UITrait}
import pl.writeonly.son2.jack.glue.CreatorConverterJack

import scala.collection.JavaConverters._

@Title("jackson converter")
@Theme("valo")
class UIConverter extends UITrait {

  override def components: List[Component] = {
    val rw = new ComponentsRW
    val input = inputTextArea
    val output = outputLabel

    val inputFormats = radioButtonGroup("Input formats:", Mappings.jacksonFormatsMapping, "JSON")
    val outputFormats = jacksonOutputFormat("YAML")
    val components: List[Component] = List(inputFormats, outputFormats) ++ rw.components

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat = selectedItem(inputFormats, Mappings.jacksonFormatsMapping)
        val outputFormat = selectedItem(outputFormats, Mappings.jacksonFormatsMapping)
        val config = Config(
          RConfig(format = inputFormat),
          WConfig(format = outputFormat)
        )
        val set = rw.nativeGroup.getValue.asScala.toSet
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterJack(config), input, output, set)
      }
    })

    return List[Component](new TopMenu().linkPanel, optionsPanel(components), input, convert, output)
  }


}
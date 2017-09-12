package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.composites.{CompositeIO, CompositeRW, CompositeRW$}
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.jack.glue.CreatorConverterJack

import scala.collection.JavaConverters._

@Title("jackson converter")
@Theme("valo")
class UIConverter extends UITrait {

  override def components2: List[Component] = {
    val rw = new CompositeRW
    val io = new CompositeIO

    val inputFormats = radioButtonGroup("Input formats:", Mappings.jacksonFormatsMapping, "JSON")
    val outputFormats = jacksonOutputFormat("YAML")
    val components: List[Component] = List(inputFormats, outputFormats) ++ rw.components

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat = selectedItem(inputFormats, Mappings.jacksonFormatsMapping)
        val outputFormat = selectedItem(outputFormats, Mappings.jacksonFormatsMapping)
        val config = Config(
          RConfig(format = inputFormat, stream = rw.readStream),
          WConfig(format = outputFormat, style = rw.writePretty)
        )
        val set = rw.set
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterJack(config), io.input, io.output, set)
      }
    })

    return List[Component](optionsPanel(components), io.input, convert, io.output)
  }
}
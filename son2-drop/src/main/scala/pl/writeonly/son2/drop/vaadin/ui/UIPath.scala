package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.path.glue.CreatorConverterPath

import scala.collection.JavaConverters._

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def components: List[Component] = {
    val rw = new ComponentsRW
    val io = new ComponentsIO

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping, "Smart");
    val outputFormats = jacksonOutputFormat("JSON")
    val components: List[Component] = List(providerGroup, outputFormats) ++ rw.components

    val inputPath = inputTextField("json-path")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val provider = Symbol(providerGroup.getSelectedItem.get())
        val config = Config(
          RConfig(format = Symbol(path), stream = rw.readStream, query = Option(path)),
          WConfig(format = provider, style = rw.writePretty)
        )

        val set = rw.nativeGroup.getValue.asScala.toSet
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterPath(config), io.input, io.output, set)
      }
    })

    return List(new TopMenu().linkPanel, optionsPanel(components), inputPath, io.input, convert, io.output)
  }
}
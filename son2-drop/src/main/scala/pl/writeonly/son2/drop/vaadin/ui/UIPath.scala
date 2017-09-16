package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.composites._
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.path.glue.{CreatorConverterPath, CreatorConverterPathMain}

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def components2: List[Component] = {
    val rw = new CompositeRW
    val io = new CompositeIO
    val pathProvider = new CompositePathProvider
    val pathOptions = new CompositePathOptions
    val jackFormats = new CompositeJack

    val components: List[Component] = pathProvider.components ++ pathOptions.components ++ jackFormats.components ++ rw.components

    val inputPath = inputTextField("json-path")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val provider = pathProvider.selectedItem
        val options = pathOptions.selectedItem
        val config = Config(
          RConfig(provider = Symbol(path), stream = rw.readStream, path = Option(path), options = options),
          WConfig(provider = provider, style = rw.writePretty)
        )

        val set = rw.set
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterPath(config), io.input, io.output, set)
      }
    })

    return List(optionsPanel(components), inputPath, io.input, convert, io.output)
  }
}
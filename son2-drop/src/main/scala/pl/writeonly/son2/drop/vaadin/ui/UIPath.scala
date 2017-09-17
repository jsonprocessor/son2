package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.complexes._
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.path.glue.CreatorConverterPath

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def componentsCenter: List[Component] = {
    val rw = new ComplexRWVertical
    val io = new ComplexIO
    val pathProvider = new ComplexPathProvider
    val pathOptions = new ComplexPathOptions
    val jackFormats = new ComplexJackFormatsVertical
    val gsonOptions = new ComplexGsonOptions
    val smartOptions = new ComplexSmartOptions

    val components: Seq[Component] = toComponents(pathProvider, pathOptions, jackFormats, gsonOptions, smartOptions, rw)

    val inputPath = inputTextField("json-path")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val provider = pathProvider.selectedItem
        val options = pathOptions.selectedItem
        val config = Config(
          RConfig(provider = provider, format = jackFormats.inputSelectedItem, stream = rw.readStream, path = Option(path), options = options),
          WConfig(provider = provider, format = jackFormats.outputSelectedItem, style = rw.writePretty, gson = gsonOptions.selectedItem)
        )

        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterPath(config), io.input, io.output, set)
      }
    })

    return List(optionsPanel(components), inputPath, io.input, convert, io.output)
  }
}
package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.vaadin.complexes._
import pl.writeonly.son2.vaadin.util._
import pl.writeonly.son2.path.glue.CreatorConverterPath
import pl.writeonly.son2.vaadin.complexes.{ComplexRWVertical, _}
import pl.writeonly.son2.vaadin.util.UITrait

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def componentsCenter: List[Component] = {
    val rw = new ComplexRWVertical
    val io = new ComplexIO
    val pathComp = new PathComp
    val smartComp = new SmartComp
    val jackFormats = new JackFormatsComp
    val gsonOptions = new GsonOptionsComp

    val tabSheet = new TabSheet
    setWidth(tabSheet)
    tabSheet.addTab(smartComp)
    tabSheet.addTab(jackFormats)
    tabSheet.addTab(gsonOptions)
    tabSheet.setSizeUndefined

    val components: Seq[Component] = Seq(rw, pathComp, tabSheet)

    val inputPath = inputTextField("json-path")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val provider = pathComp.provider.selectedItem
        val options = pathComp.options.selectedItem
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
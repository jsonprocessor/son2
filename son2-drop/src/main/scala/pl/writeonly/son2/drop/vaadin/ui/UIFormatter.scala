package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.complexes._
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.json.glue.CreatorConverterJson

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  override def componentsCenter: List[Component] = {
    val rw = new ComplexRWVertical
    val io = new ComplexIO
    val pathProvider = new PathProviderComp
    val smartComp = new SmartComp
    val jackFormats = new JackFormatsComp
    val gsonOptions = new GsonOptionsComp

    val tabSheet = new TabSheet
    setWidth(tabSheet)
    tabSheet.addTab(smartComp)
    tabSheet.addTab(jackFormats)
    tabSheet.addTab(gsonOptions)

    val components: Seq[Component] = Seq(rw, pathProvider, tabSheet)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val provider = pathProvider.selectedItem
        val config = Config(
          RConfig(provider = provider, format = jackFormats.inputSelectedItem, stream = rw.readStream, path = null),
          WConfig(provider = provider, format = jackFormats.outputSelectedItem, style = rw.writePretty, gson = gsonOptions.selectedItem)
        )
        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterJson(config), io.input, io.output, set)
      }
    })

    return List(optionsPanel(components), io.input, convert, io.output)
  }
}
package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, RPath, WConfig}
import pl.writeonly.son2.json.glue.CreatorConverterJson
import pl.writeonly.son2.vaadin.complexes.captioneds._
import pl.writeonly.son2.vaadin.complexes.hasselecteditems.PathProviderComp
import pl.writeonly.son2.vaadin.complexes.{ComplexRWVertical, _}

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait2 {

  override def componentsCenter2: Components = new Components() {
    val rw = new ComplexRWVertical
    val io = new ComplexIO
    val pathProvider = new PathProviderComp
    val smartComp = new SmartComp
    val jackFormats = new JackComp
    val gsonOptions = new GsonComp

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
          RConfig(provider = provider, format = jackFormats.inputSelectedItem, stream = rw.readStream, path = RPath.parse),
          WConfig(provider = provider, format = jackFormats.outputSelectedItem, style = rw.writePretty, gson = gsonOptions.options.selectedItem))
        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterJson(config), io.input, io.output, set)
      }
    })
    val inputs = List(io.input)
    val output = io.output
  }

}
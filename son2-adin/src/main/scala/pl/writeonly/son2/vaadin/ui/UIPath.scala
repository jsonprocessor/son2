package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, RPath, WConfig}
import pl.writeonly.son2.path.glue.CreatorConverterPath
import pl.writeonly.son2.vaadin.complexes.captioneds._
import pl.writeonly.son2.vaadin.complexes.{ComplexRWVertical, _}

@Title("json path")
@Theme("valo")
class UIPath extends UITrait2 {

  override def componentsCenter2: Components = new Components() {
    val rw = new ComplexRWVertical
    val io = new ComplexIO
    val pathComp = new PathComp
    val smartComp = new SmartComp
    val jackComp = new JackComp
    val gsonComp = new GsonComp

    val tabSheet = new TabSheet
    setWidth(tabSheet)
    tabSheet.addTab(smartComp)
    tabSheet.addTab(jackComp)
    tabSheet.addTab(gsonComp)
    tabSheet.setSizeUndefined

    val components: Seq[Component] = Seq(rw, pathComp, tabSheet)

    val inputPath = inputTextField("json-path")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPath.getValue
        val provider = pathComp.provider.selectedItem
        val options = pathComp.options.selectedItem
        val config = Config(
          RConfig(provider = provider, format = jackComp.inputSelectedItem, stream = rw.readStream, path = RPath(path), options = options),
          WConfig(provider = provider, format = jackComp.outputSelectedItem, style = rw.writePretty, gson = gsonComp.options.selectedItem))

        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterPath(config), io.input, io.output, set)
      }
    })

    val inputs = List(inputPath, io.input)
    val output = io.output
  }
}
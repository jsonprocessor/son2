package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.vaadin.complexes._
import pl.writeonly.son2.vaadin.util._
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.son2.vaadin.complexes.captioneds.JackComp
import pl.writeonly.son2.vaadin.complexes.{ComplexIO, ComplexRWHorizontal}
import pl.writeonly.son2.vaadin.util.UITrait

@Title("jackson converter")
@Theme("valo")
class UIConverter extends UITrait {

  override def componentsCenter: List[Component] = {
    val rw = new ComplexRWHorizontal
    val io = new ComplexIO
    val jackFormats = new JackComp

    val components: Seq[Component] = Seq(jackFormats, rw)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat = jackFormats.inputSelectedItem
        val outputFormat = jackFormats.outputSelectedItem
        val config = Config(
          RConfig(provider = inputFormat, format = inputFormat, stream = rw.readStream),
          WConfig(provider = outputFormat, format = outputFormat, style = rw.writePretty)
        )
        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterJack(config), io.input, io.output, set)
      }
    })

    return List[Component](optionsPanel(components), io.input, convert, io.output)
  }
}
package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.son2.vaadin.complexes.captioneds.JackComp
import pl.writeonly.son2.vaadin.complexes.{ComplexIO, ComplexRWHorizontal}

@Title("jackson converter")
@Theme("valo")
class UIConverter extends UITrait2 {

  override def componentsCenter2: Components = new Components() {
    val rw = new ComplexRWHorizontal
    val io = new ComplexIO
    val jackFormats = new JackComp

    val components: Seq[Component] = Seq(jackFormats, rw)

    val convert: Button = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat = jackFormats.inputSelectedItem
        val outputFormat = jackFormats.outputSelectedItem
        val config = Config(
          RConfig(provider = inputFormat, format = inputFormat, stream = rw.readStream),
          WConfig(provider = outputFormat, format = outputFormat, style = rw.writePretty))
        val set = rw.set
        logger.info("{} {}", config, set)
        convert2(CreatorConverterJack(config), io.input, io.output, set)
      }
    })
    val inputs = Seq(io.input)
    val output = io.output
  }
}
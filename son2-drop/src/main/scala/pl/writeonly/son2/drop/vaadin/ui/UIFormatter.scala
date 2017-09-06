package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.util._
import pl.writeonly.son2.json.glue.CreatorConverterJson

import scala.collection.JavaConverters._

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  override def components: List[Component] = {
    val rw = new ComponentsRW
    val io = new ComponentsIO

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping)

    val components: List[Component] = List(providerGroup) ++ rw.components

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val provider = selectedItem(providerGroup, Mappings.pathProvidersMapping)
        val config = Config(
          RConfig(format = provider, stream = rw.readSelectedItem.equals('stream)),
          WConfig(format = provider, style = rw.readSelectedItem.equals('style))
        )
        val set = rw.nativeGroup.getValue.asScala.toSet
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterJson(config), io.input, io.output, set)
      }
    })

    return List(new TopMenu().linkPanel, optionsPanel(components), io.input, convert, io.output)
  }
}
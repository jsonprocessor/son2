package pl.writeonly.son2.drop.vaadin.ui

import java.util.Optional

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.util.JavaFunctions._
import pl.writeonly.son2.drop.vaadin.util.{ComponentsRW, Mappings, TopMenu, UITrait}
import pl.writeonly.son2.json.glue.CreatorConverterJson

import scala.collection.JavaConverters._

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  override def components: List[Component] = {
    val rw = new ComponentsRW
    val input = inputTextArea
    val output = outputLabel

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping)

    val components: List[Component] = List(providerGroup) ++ rw.components

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val provider = selectedItem(providerGroup, Mappings.pathProvidersMapping)
        val config = Config(
          RConfig(format = provider),
          WConfig(format = provider)
        )
        val set = rw.nativeGroup.getValue.asScala.toSet
        debug(rw.configLabel, config, set)
        convert2(CreatorConverterJson(config), input, output, set)
      }
    })

    return List(new TopMenu().linkPanel, optionsPanel(components), input, convert, output)
  }
}
package pl.writeonly.son2.drop.vaadin.ui

import java.util.Optional

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.json.glue.CreatorConverterJson

import scala.collection.JavaConverters._
import pl.writeonly.son2.drop.vaadin.JavaFunctions._

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  val providersMapping = Map[String, Symbol](
    "Smart" -> 'smart,
    "Strict" -> 'strict,
    "Gson" -> 'gson,
    "Jackson" -> 'object
  )
  val providers = providersMapping.keys


  override def components: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val providerGroup = new RadioButtonGroup[String]("Providers", providers.asJavaCollection)
    providerGroup.setSelectedItem(providers.iterator.next)

    val components: List[Component] = List(providerGroup, checkBoxes, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val provider : Optional[Symbol] = providerGroup.getSelectedItem().map((it: String) => providersMapping.get(it).get)
        val config = Config(
          RConfig(format = provider.get),
          WConfig(format = provider.get)
        )
        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterJson(config), input, output, set)
      }
    })

    return List(linkPanel, optionsPanel(components), input, convert, output)
  }
}
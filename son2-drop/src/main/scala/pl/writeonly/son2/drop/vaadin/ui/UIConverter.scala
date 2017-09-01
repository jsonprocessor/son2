package pl.writeonly.son2.drop.vaadin.ui

import java.util.Optional

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.drop.vaadin.JavaFunctions._
import pl.writeonly.son2.jack.glue.CreatorConverterJack

import scala.collection.JavaConverters._

@Title("json converter")
@Theme("valo")
class UIConverter extends UITrait {

  val formatsMapping = Map[String, Symbol]("JSON" -> 'object, "YAML" -> 'yaml, "XML" -> 'xml, "Java properties" -> 'properties)
  val formats = formatsMapping.keys


  override def components: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val inputFormats = new RadioButtonGroup[String]("Input formats:", formats.asJavaCollection)
    inputFormats.setSelectedItem("JSON")
    val outputFormats = new RadioButtonGroup[String]("Output formats:", formats.asJavaCollection)
    outputFormats.setSelectedItem("YAML")
    val components: List[Component] = List(inputFormats, outputFormats, checkBoxes, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat: Optional[Symbol] = inputFormats.getSelectedItem().map((it: String) => formatsMapping.get(it).get)
        val outputFormat: Optional[Symbol] = outputFormats.getSelectedItem().map((it: String) => formatsMapping.get(it).get)
        val config = Config(
          RConfig(format = inputFormat.get),
          WConfig(format = outputFormat.get)
        )
        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterJack(config), input, output, set)
      }
    })

    return List[Component](linkPanel, optionsPanel(components), input, convert, output)
  }


}
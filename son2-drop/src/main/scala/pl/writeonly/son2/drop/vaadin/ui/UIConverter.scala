package pl.writeonly.son2.drop.vaadin.ui

import java.util.Optional

import com.google.common.collect.ImmutableList
import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.glue.Streamers
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.glue.CreatorProviderJack

import scala.collection.JavaConverters._
import pl.writeonly.son2.drop.vaadin.JavaFunctions._

@Title("json converter")
@Theme("valo")
class UIConverter extends UITrait {

  val formatsMapping = Map[String, Symbol]("JSON" -> 'object, "YAML" -> 'yaml, "XML" -> 'xml, "Java properties" -> 'propierties)
  val formats = formatsMapping.keys
  val natives = List("Print", "String")



  override def components: List[Component] = {
    val input = inputTextArea
    val output = outputLabel
    val configLabel = outputLabel

    val inputFormats = new RadioButtonGroup[String]("Input formats:", formats.asJavaCollection)
    val outputFormats = new RadioButtonGroup[String]("Output formats:", formats.asJavaCollection)
    val checkBoxes = new CheckBoxGroup("Native", natives.asJavaCollection)
    val components: List[Component] = List(inputFormats, outputFormats, checkBoxes, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat :Optional[Symbol] = inputFormats.getSelectedItem().map((it:String) => formatsMapping.get(it).get)
        val outputFormat :Optional[Symbol] = outputFormats.getSelectedItem().map((it:String) => formatsMapping.get(it).get)
        val config = Config(
          RConfig(format = inputFormat.orElse('object)),
          WConfig(format = outputFormat.orElse('yaml))
        )
        configLabel.setValue(config.toString + "\n" + checkBoxes.getValue.asScala.toSet)

        val provider = CreatorProviderJack(config)
        convert2(provider, input, output, checkBoxes.getValue.asScala.toSet)
      }
    })

    return List[Component](linkPanel, optionsPanel(components), input, convert, output)
  }



}
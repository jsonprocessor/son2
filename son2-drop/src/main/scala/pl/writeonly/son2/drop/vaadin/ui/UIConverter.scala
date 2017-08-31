package pl.writeonly.son2.drop.vaadin.ui

import com.google.common.collect.ImmutableList
import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.jack.glue.CreatorProviderJack

import scala.collection.JavaConverters._


@Title("json converter")
@Theme("valo")
class UIConverter extends UITrait {

  override def components: List[Component] = {
    val input = inputTextArea
    val output = outputLabel

    val formatsMapping = Map("JSON" -> 'object, "YAML" -> 'yaml, "XML" -> 'xml, "Java properties" -> 'propierties)
    val formats = formatsMapping.keys
    val inputFormats = new RadioButtonGroup[String]("Input formats", formats.asJavaCollection)
    val outputFormats = new RadioButtonGroup[String]("Output formats", formats.asJavaCollection)

    val components: List[Component] = List(inputFormats, outputFormats)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val inputFormat = inputFormats.getSelectedItem()
        val outputFormat = inputFormats.getSelectedItem()
        val config = Config(RConfig(), WConfig())
//        CreatorProviderJack()
      }
    })

    return List[Component](toBackLink, input, optionsPanel(components), convert, output)
  }
}
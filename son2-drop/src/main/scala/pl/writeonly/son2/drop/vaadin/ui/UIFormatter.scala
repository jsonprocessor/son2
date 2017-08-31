package pl.writeonly.son2.drop.vaadin.ui

import com.google.common.collect.ImmutableList
import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import scala.collection.JavaConverters._

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  override def components: List[Component] = {

    val input = inputTextArea
    val output = outputLabel

    val providers = List[String]("Gson", "Jackson", "Smart")

    val providerGroup = new RadioButtonGroup[String]("Providers", providers.asJavaCollection)

    val components: List[Component] = List(providerGroup)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {

      }
    })

    return List(toBackLink, input, optionsPanel(components), convert, output)
  }
}
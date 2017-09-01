package pl.writeonly.son2.drop.vaadin.ui

import com.google.common.collect.ImmutableList
import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._

@Title("json path")
@Theme("valo")
class UIPath extends UITrait {

  override def components: List[Component] = {

    val input = inputTextArea
    val output = outputLabel

    val providers = new RadioButtonGroup[String]("Providers", ImmutableList.of("One", "Two", "Three"));

    val components: List[Component] = List(providers)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
      }
    });

    return List(linkPanel, input, optionsPanel(components), convert, output)
  }
}
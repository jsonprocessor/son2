package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.ExternalResource
import com.vaadin.ui._

trait UIUtil extends UI {

  def layoutVerticalLayout: VerticalLayout = {
    val result = new VerticalLayout()
    setWidth(result)
    result.setSpacing(true)
    result.setMargin(true)
    result
  }

  def linkPanel: Panel = horizontaPanel("Menu", mainLink, jsonFormatterLink, jsonConverterLink)

  def horizontaPanel(caption: String, components: Component*) = new Panel(caption, new HorizontalLayout(components: _*))

  def mainLink: Link = link("Main", "/ui");

  def jsonFormatterLink: Link = link("Json Formatter", "/ui/formatter");

  def jsonConverterLink: Link = link("Json Converter", "/ui/converter");

  def link(caption: String, sourceURL: String) = new Link(caption, new ExternalResource(sourceURL));

  def inputTextArea: TextArea = inputTextArea(inputJson)

  def inputJson = "Input Json"

  def inputTextArea(caption: String): TextArea = {
    val result = new TextArea(caption)
    result.setEnabled(true)
    setWidth(result)
    result
  }

  def optionsPanel(components: List[Component]): Panel = {
    val result = new Panel("Options", optionsHorizontalLayout(components))
    setWidth(result)
    result
  }

  def optionsHorizontalLayout(components: List[Component]): HorizontalLayout = {
    new HorizontalLayout(components: _*)
  }

  def convertButton(listener: Button.ClickListener): Button = {
    val result = new Button("Convert", listener)
    setWidth(result)
    result
  }

  def outputLabel: Label = {
    val result = new Label()
    setWidth(result)
    result
  }

  def setWidth(c: AbstractComponent) = c.setWidth("100%")


}

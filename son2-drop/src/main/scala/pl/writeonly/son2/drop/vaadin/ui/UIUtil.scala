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

  def link(caption: String, sourceURL: String) = new Link(caption, new ExternalResource(sourceURL));

  def toBackLink: Link = new Link("back", new ExternalResource(""));

  def inputTextArea: TextArea = inputTextArea(inputJson)

  def inputJson = "Input Json"

  def inputTextArea(caption: String): TextArea = {
    val result = new TextArea(caption)
    result.setEnabled(true)
    setWidth(result)
    result
  }

  def setWidth(c: AbstractComponent) = c.setWidth("100%")

  def optionsPanel(components: List[Component]): Panel = {
    val result = new Panel("Options", optionsVerticalLayout(components))
    setWidth(result)
    result
  }

  def optionsVerticalLayout(components: List[Component]): VerticalLayout = {
    val result = new VerticalLayout(components: _*)
    result
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
}

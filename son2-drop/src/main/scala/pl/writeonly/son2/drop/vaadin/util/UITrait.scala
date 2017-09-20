package pl.writeonly.son2.drop.vaadin.util

import com.typesafe.scalalogging.LazyLogging
import com.vaadin.server.VaadinRequest
import com.vaadin.ui._
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.glue.Piper
import pl.writeonly.son2.drop.vaadin.complexes.Complex


trait UITrait extends UI with UIUtil with LazyLogging {

  val natives = List("Print", "String")

  def nativeGroup = checkBoxGroupNative("Native:", natives)

  def debug(configLabel: Label, config: Any, set: Set[_]) = configLabel.setValue(config.toString + "\n" + set)

  def convert2(converter: Converter, input: TextArea, output: Label, items: Set[String]) = {
    val inputValue = input.getValue
    val streamer = new Piper(null, converter).print(items.contains("Print"))
    val outputValue = streamer.convertString(items.contains("String"), inputValue)
    output.setValue(outputValue)
  }

  //  def debug(configLabel: Label, config: Config, set: Set[String]) = configLabel.setValue(config.toString + "\n" + set)

  def optionsPanel(components: Seq[Component]): Panel = {
    val result = new Panel("Options", optionsHorizontalLayout(components))
    setWidth(result)
    result
  }

  def inputTextArea: TextArea = inputTextArea(inputJson)

  def inputJson = "Input Json"

  def convertButton(listener: Button.ClickListener): Button = {
    val result = new Button("Convert", listener)
    setWidth(result)
    result
  }

  def toComponents(complexes: Complex*) = complexes.map(_.toComponent)

  @Override
  override protected def init(vaadinRequest: VaadinRequest): Unit = {
    val layout = verticalLayout
    setContent(layout)
    layout.addComponents(components: _*)
  }

  def components: List[Component] = List(new TopMenu().linkPanel) ++ componentsCenter

  def componentsCenter: List[Component] = List()

}

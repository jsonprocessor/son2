package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.{CheckBoxGroup, _}
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.glue.Streamers
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UIUtil}

import scala.collection.JavaConverters._


trait UITrait extends UI with UIUtil {

  def jacksonOutputFormat(selected:String) = radioButtonGroup("Output formats:", Mappings.jacksonFormatsMapping, selected)


  val natives = List("Print", "String")

  val natives2 = List("Stream", "Pretty")




  def components: List[Component]

  def nativeGroup = new CheckBoxGroup("Native:", natives.asJavaCollection)

  def readGroup = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroup = radioButtonGroup("Write:", Mappings.writeMapping)


  def debug(configLabel: Label, config: Config, set: Set[String]) = configLabel.setValue(config.toString + "\n" + set)

  def convert2(provider: Converter, input: TextArea, output: Label, items: Set[String]) = {
    val inputValue = input.getValue
    val streamer = Streamers.print(items.contains("Print"), false, provider)
    val outputValue = streamer.convertString(items.contains("String"), inputValue)
    output.setValue(outputValue)
  }

  def linkPanel: Panel = horizontaPanelEx("Top Menu",
    mainLink,
    jacksonConverter,
    jsonComparatorLink,
    jsonDiffLink,
    jsonFormatterLink,
    jsonPatchLink,
    jsonPathLink)

  def mainLink: Link = link("Main Side", "/ui");

  def jacksonConverter: Link = link("Jackson Converter", "/ui/converter");

  def jsonComparatorLink: Link = link("Json Comparator", "/ui/comparator");
  def jsonDiffLink: Link = link("Json Diff", "/ui/diff");
  def jsonFormatterLink: Link = link("Json Formatter", "/ui/formatter");
  def jsonPatchLink: Link = link("Json Patch", "/ui/patch");
  def jsonPathLink: Link = link("Json Path", "/ui/path");

  def optionsPanel(components: List[Component]): Panel = {
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

  @Override
  override protected def init(vaadinRequest: VaadinRequest): Unit = {
    val layout = layoutVerticalLayout
    setContent(layout)
    layout.addComponents(components: _*)
  }


}

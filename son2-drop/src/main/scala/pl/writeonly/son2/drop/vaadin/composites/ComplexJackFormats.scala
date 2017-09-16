package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{UITrait}

class ComplexJackFormats extends Complex {
  protected val inputFormats = ComplexJackFormats.jacksonInputFormat
  protected val outputFormats = ComplexJackFormats.jacksonOutputFormat
  protected val vertical = ComplexJackFormats.verticalPanel("Jackson options:", inputFormats, outputFormats)
  protected val horizonta = ComplexJackFormats.horizontalPanel("Jackson options:", inputFormats, outputFormats)

  def inputSelectedItem = ComplexJackFormats.selectedItem(inputFormats, ComplexJackFormats.mapping)
  def outputSelectedItem = ComplexJackFormats.selectedItem(outputFormats, ComplexJackFormats.mapping)


  override def components: List[Component] = List(inputFormats, outputFormats)
}

class ComplexJackFormats2 extends ComplexJackFormats {

  override def components: List[Component] = List(vertical)
}

object ComplexJackFormats extends UITrait {
  private val mapping = Map[String, Symbol](
    "JSON" -> 'object,
    "YAML" -> 'yaml,
    "XML" -> 'xml,
    "Java properties" -> 'properties)

  def jacksonInputFormat = radioButtonGroup("Jackson input formats:", ComplexJackFormats.mapping, "JSON")

  def jacksonOutputFormat = radioButtonGroup("Jackson output formats:", ComplexJackFormats.mapping, "YAML")

}

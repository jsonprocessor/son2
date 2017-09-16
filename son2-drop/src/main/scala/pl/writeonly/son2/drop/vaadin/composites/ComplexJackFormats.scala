package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait, UIUtil}

class ComplexJackFormats extends Complex {
  private val inputFormats = ComplexJackFormats.jacksonInputFormat
  private val outputFormats = ComplexJackFormats.jacksonOutputFormat

  def inputSelectedItem = ComplexJackFormats.selectedItem(inputFormats, ComplexJackFormats.mapping)
  def outputSelectedItem = ComplexJackFormats.selectedItem(outputFormats, ComplexJackFormats.mapping)

  override def components: List[Component] = List(inputFormats, outputFormats)
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

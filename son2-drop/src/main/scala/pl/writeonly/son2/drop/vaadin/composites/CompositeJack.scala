package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait, UIUtil}

class CompositeJack extends Composite {
  private val inputFormats = CompositeJack.jacksonInputFormat
  private val outputFormats = CompositeJack.jacksonOutputFormat

  def inputSelectedItem = CompositeJack.selectedItem(inputFormats, CompositeJack.jacksonFormatsMapping)
  def outputSelectedItem = CompositeJack.selectedItem(outputFormats, CompositeJack.jacksonFormatsMapping)

  override def components: List[Component] = List(inputFormats, outputFormats)
}

object CompositeJack extends UITrait {
  private val jacksonFormatsMapping = Map[String, Symbol](
    "JSON" -> 'object,
    "YAML" -> 'yaml,
    "XML" -> 'xml,
    "Java properties" -> 'properties)

  def jacksonInputFormat = radioButtonGroup("Jackson input formats:", CompositeJack.jacksonFormatsMapping, "JSON")

  def jacksonOutputFormat = radioButtonGroup("Jackson output formats:", CompositeJack.jacksonFormatsMapping, "YAML")

}

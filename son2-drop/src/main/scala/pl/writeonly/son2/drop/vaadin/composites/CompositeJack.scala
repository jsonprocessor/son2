package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait, UIUtil}

class CompositeJack extends Composite {
  val inputFormats = CompositeJack.jacksonInputFormat
  val outputFormats = CompositeJack.jacksonOutputFormat

  override def components: List[Component] = List(inputFormats, outputFormats)
}

object CompositeJack extends UITrait {
  def jacksonInputFormat = radioButtonGroup("Jackson input formats:", Mappings.jacksonFormatsMapping, "JSON")

  def jacksonOutputFormat = radioButtonGroup("Jackson output formats:", Mappings.jacksonFormatsMapping, "YAML")

}

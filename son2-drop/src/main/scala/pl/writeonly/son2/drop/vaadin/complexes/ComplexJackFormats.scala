package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait

object ComplexJackFormats extends UITrait {
  private val mapping = Map[String, Symbol](
    "JSON" -> 'object,
    "YAML" -> 'yaml,
    "XML" -> 'xml,
    "Java properties" -> 'properties)

  def jacksonInputFormat = radioButtonGroup("Jackson input formats:", mapping, "JSON")

  def jacksonOutputFormat = radioButtonGroup("Jackson output formats:", mapping, "YAML")
}

abstract class ComplexJackFormats extends Complex {
  protected val inputFormats = ComplexJackFormats.jacksonInputFormat
  protected val outputFormats = ComplexJackFormats.jacksonOutputFormat

  def inputSelectedItem = ComplexJackFormats.selectedItem(inputFormats, ComplexJackFormats.mapping)

  def outputSelectedItem = ComplexJackFormats.selectedItem(outputFormats, ComplexJackFormats.mapping)
}


class ComplexJackFormatsHorizontal extends ComplexJackFormats {
  private val layout = ComplexJackFormats.horizontalLayout(inputFormats, outputFormats)

  override def toComponent: Component = layout
}

class ComplexJackFormatsVertical extends ComplexJackFormats {
  private val layout = ComplexJackFormats.verticalLayout(inputFormats, outputFormats)

  override def toComponent: Component = layout
}


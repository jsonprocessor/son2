package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

object ComplexJackFormats extends UITrait {
  private val json = ItemSymbol('object, "json")
  private val yaml = ItemSymbol('yaml)
  private val xml = ItemSymbol('xml)
  private val properties = ItemSymbol('properties, "java properties")

  private val items = Set(json, yaml, xml, properties)

  def jacksonInputFormat = radioButtonGroup2("Jackson input formats:", items, json)

  def jacksonOutputFormat = radioButtonGroup2("Jackson output formats:", items, yaml)
}

abstract class ComplexJackFormats extends Complex {
  protected val inputFormats = ComplexJackFormats.jacksonInputFormat
  protected val outputFormats = ComplexJackFormats.jacksonOutputFormat

  def inputSelectedItem = ComplexJackFormats.selectedItem2(inputFormats).value

  def outputSelectedItem = ComplexJackFormats.selectedItem2(outputFormats).value
}


class ComplexJackFormatsHorizontal extends ComplexJackFormats {
  private val layout = ComplexJackFormats.horizontalLayout(inputFormats, outputFormats)

  override def toComponent: Component = layout
}

class ComplexJackFormatsVertical extends ComplexJackFormats {
  private val layout = ComplexJackFormats.verticalLayout(inputFormats, outputFormats)

  override def toComponent: Component = layout
}


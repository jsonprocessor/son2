package pl.writeonly.son2.vaadin.complexes

import pl.writeonly.son2.vaadin.util.{ItemSymbol, UITrait}


class JackFormatsComp extends Complex {
  setCaption("Jackson")
  protected val inputFormats = JackFormatsComp.jacksonInputFormat
  protected val outputFormats = JackFormatsComp.jacksonOutputFormat
  private val layout = JackFormatsComp.horizontalLayout(inputFormats, outputFormats)
  set(layout)

  def inputSelectedItem = JackFormatsComp.selectedItem(inputFormats).value

  def outputSelectedItem = JackFormatsComp.selectedItem(outputFormats).value

}

object JackFormatsComp extends UITrait {
  private val json = ItemSymbol('object, "json")
  private val yaml = ItemSymbol('yaml)
  private val xml = ItemSymbol('xml)
  private val properties = ItemSymbol('properties, "java properties")

  private val items = Set(json, yaml, xml, properties)

  def jacksonInputFormat = radioButtonGroup("Jackson input formats:", items, json)

  def jacksonOutputFormat = radioButtonGroup("Jackson output formats:", items, yaml)
}




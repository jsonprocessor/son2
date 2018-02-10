package pl.writeonly.son2.vaadin.complexes.hasselecteditems

import pl.writeonly.son2.vaadin.complexes.{Complex, HasRadioButtonSelectedItem}
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

class JackFormatComp(val caption: String, selected: ItemSymbol) extends Complex with HasRadioButtonSelectedItem {
  protected val component = JackFormatComp.format(caption, selected)
  set(component)

  def selectedItem = JackFormatComp.selectedItem(component).value
}

object JackFormatComp extends UIUtil {
  private val json = ItemSymbol('object, "json")
  private val yaml = ItemSymbol('yaml)
  private val xml = ItemSymbol('xml)
  private val properties = ItemSymbol('properties, "java properties")

  private val items = Set(json, yaml, xml, properties)

  def format(caption: String, selected: ItemSymbol) = radioButtonGroup(caption, items, selected)

  def jacksonInputFormat = new JackFormatComp("Jackson input formats:", json)

  def jacksonOutputFormat = new JackFormatComp("Jackson output formats:", yaml)

}

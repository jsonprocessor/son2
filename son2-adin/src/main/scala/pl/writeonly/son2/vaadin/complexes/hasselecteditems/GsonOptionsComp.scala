package pl.writeonly.son2.vaadin.complexes.hasselecteditems

import pl.writeonly.son2.vaadin.complexes.{Complex, HasCheckBoxSelectedItem}
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

class GsonOptionsComp extends Complex with HasCheckBoxSelectedItem {
  private val component = GsonOptionsComp.apply
  set(component)

  def selectedItem = PathOptionsComp.selectedItem(component).map(_.value)
}

object GsonOptionsComp extends UIUtil {
  private val items = Set(
    ItemSymbol('disableHtmlEscaping),
    ItemSymbol('disableInnerClassSerialization),
    ItemSymbol('enableComplexMapKeySerialization),
    ItemSymbol('excludeFieldsWithoutExposeAnnotation),
    ItemSymbol('generateNonExecutableJson),
    ItemSymbol('serializeNulls),
    ItemSymbol('serializeSpecialFloatingPointValues),
    ItemSymbol('setLenient))

  private def apply = checkBoxGroup("Gson options:", items)
}

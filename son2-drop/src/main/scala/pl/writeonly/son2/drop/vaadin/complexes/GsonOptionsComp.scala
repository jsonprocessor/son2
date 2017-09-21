package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class GsonOptionsComp extends Complex {
  private val component = GsonOptionsComp.apply

  override def toComponent: Component = component

  def selectedItem = PathOptionsComp.selectedItem(component).map(_.value)
}

object GsonOptionsComp extends UITrait {
  private val items = Set(
    ItemSymbol('disableHtmlEscaping),
    ItemSymbol('disableInnerClassSerialization),
    ItemSymbol('enableComplexMapKeySerialization),
    ItemSymbol('excludeFieldsWithoutExposeAnnotation),
    ItemSymbol('generateNonExecutableJson),
    ItemSymbol('serializeNulls),
    ItemSymbol('serializeSpecialFloatingPointValues),
    ItemSymbol('setLenient)
  )

  private def apply = checkBoxGroup("Gson options:", items)
}

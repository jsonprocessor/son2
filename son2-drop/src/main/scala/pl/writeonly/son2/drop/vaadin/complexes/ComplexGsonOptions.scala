package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class ComplexGsonOptions extends Complex {
  private val component = ComplexGsonOptions.apply

  override def toComponent: Component = component

  def selectedItem = ComplexPathOptions.selectedItem2(component).map(_.value)
}

object ComplexGsonOptions extends UITrait {
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

  private def apply = checkBoxGroup2("Gson options:", items)
}

package pl.writeonly.son2.vaadin.complexes

import pl.writeonly.son2.vaadin.util.{ItemSymbol, UITrait}

class GsonOptionsComp extends ComplexWithCaption("Gson") {
  private val component = GsonOptionsComp.apply
  set(component)

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

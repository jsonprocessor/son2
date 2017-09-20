package pl.writeonly.son2.drop.vaadin.complexes

import com.jayway.jsonpath.{Option => jOption}
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class ComplexPathOptions extends Complex {
  private val component = ComplexPathOptions.apply

  override def toComponent: Component = component

  def selectedItem = ComplexPathOptions.selectedItem(component).map(_.value)
}

object ComplexPathOptions extends UITrait {
  private val items = Set[ItemSymbol](
    ItemSymbol(toSymbol(jOption.AS_PATH_LIST), "As path list"),
    ItemSymbol(toSymbol(jOption.ALWAYS_RETURN_LIST), "Always return list"),
    ItemSymbol(toSymbol(jOption.DEFAULT_PATH_LEAF_TO_NULL), "default path leaf to null"),
    ItemSymbol(toSymbol(jOption.REQUIRE_PROPERTIES), "requite properties"),
    ItemSymbol(toSymbol(jOption.SUPPRESS_EXCEPTIONS), "suppress exception")
  )

  private def toSymbol(option: jOption) = Symbol(option.name())

  private def apply = checkBoxGroup("Path options:", items)
}

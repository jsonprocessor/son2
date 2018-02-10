package pl.writeonly.son2.vaadin.complexes.hasselecteditems

import com.jayway.jsonpath.{Option => jOption}
import pl.writeonly.son2.vaadin.complexes.{Complex, HasCheckBoxSelectedItem}
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

class PathOptionsComp extends Complex with HasCheckBoxSelectedItem {
  private val component = PathOptionsComp.apply
  set(component)

  def selectedItem: Set[Symbol] = PathOptionsComp.selectedItem(component).map(_.value)
}

object PathOptionsComp extends UIUtil {
  private val items = Set[ItemSymbol](
    ItemSymbol(toSymbol(jOption.AS_PATH_LIST), "As path list"),
    ItemSymbol(toSymbol(jOption.ALWAYS_RETURN_LIST), "Always return list"),
    ItemSymbol(toSymbol(jOption.DEFAULT_PATH_LEAF_TO_NULL), "default path leaf to null"),
    ItemSymbol(toSymbol(jOption.REQUIRE_PROPERTIES), "requite properties"),
    ItemSymbol(toSymbol(jOption.SUPPRESS_EXCEPTIONS), "suppress exception"))

  private def toSymbol(option: jOption) = Symbol(option.name())

  private def apply = checkBoxGroup("Path options:", items)
}

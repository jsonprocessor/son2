package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{CheckBoxGroup, Component}
import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexSmartOptions extends Complex {
  private val component = ComplexSmartOptions.apply

  override def components: List[Component] = List(toComponent)

  override def toComponent: Component = component

  def selectedItem = ComplexSmartOptions.selectedItem(component)
}

object ComplexSmartOptions extends UITrait {
  val MODE_JSON_SIMPLE: Set[Symbol] = Set(
    'ACCEPT_USELESS_COMMA,
    'USE_HI_PRECISION_FLOAT,
    'ACCEPT_TAILLING_DATA,
    'ACCEPT_TAILLING_SPACE,
    'REJECT_127_CHAR)
  val MODE_RFC4627: Set[Symbol] = Set(
    'USE_INTEGER_STORAGE,
    'USE_HI_PRECISION_FLOAT,
    'ACCEPT_TAILLING_SPACE)
  val MODE_STRICTEST: Set[Symbol] = Set(
    'USE_INTEGER_STORAGE,
    'USE_HI_PRECISION_FLOAT,
    'REJECT_127_CHAR)
  val MODE_PERMISSIVE = 'MODE_PERMISSIVE
  private val mapping = Map[String, Symbol](
    "ACCEPT_SIMPLE_QUOTE" -> 'ACCEPT_SIMPLE_QUOTE,
    "ACCEPT_NON_QUOTE" -> 'ACCEPT_NON_QUOTE,
    "ACCEPT_NAN" -> 'ACCEPT_NAN,
    "IGNORE_CONTROL_CHAR" -> 'IGNORE_CONTROL_CHAR,
    "USE_INTEGER_STORAGE" -> 'USE_INTEGER_STORAGE,
    "ACCEPT_LEADING_ZERO" -> 'ACCEPT_LEADING_ZERO,
    "ACCEPT_USELESS_COMMA" -> 'ACCEPT_USELESS_COMMA,
    "USE_HI_PRECISION_FLOAT" -> 'USE_HI_PRECISION_FLOAT,
    "ACCEPT_TAILLING_DATA" -> 'ACCEPT_TAILLING_DATA,
    "ACCEPT_TAILLING_SPACE" -> 'ACCEPT_TAILLING_SPACE,
    "ACCEPT_USELESS_COMMA" -> 'ACCEPT_USELESS_COMMA,
    "REJECT_127_CHAR" -> 'REJECT_127_CHAR
  )

  private def apply = checkBoxGroup("Smart options:", ComplexSmartOptions.mapping)

  private def selectedItem(component: CheckBoxGroup[String]): Set[Symbol] = selectedItem(component, ComplexSmartOptions.mapping)


}

package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{CheckBoxGroup, Component}
import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexSmartOptions extends Complex {
    private val component = ComplexSmartOptions.apply
  override def toComponent: Component = component
  override def components: List[Component] = List(toComponent)
    def selectedItem = ComplexSmartOptions.selectedItem(component)
  }

object ComplexSmartOptions extends UITrait {
  private val mapping = Map[String, Symbol](
    "disableHtmlEscaping" -> 'disableHtmlEscaping,
    "disableInnerClassSerialization" -> 'disableInnerClassSerialization,
    "enableComplexMapKeySerialization" -> 'enableComplexMapKeySerialization,
    "excludeFieldsWithoutExposeAnnotation" -> 'excludeFieldsWithoutExposeAnnotation,
    "generateNonExecutableJson" -> 'generateNonExecutableJson,
    "serializeNulls" -> 'serializeNulls,
    "serializeSpecialFloatingPointValues" -> 'serializeSpecialFloatingPointValues,
    "setLenient" -> 'setLenient
  )

  private def apply = checkBoxGroup("Smart options:", ComplexSmartOptions.mapping)

  private def selectedItem(component : CheckBoxGroup[String]) : Set[Symbol] = selectedItem(component, ComplexSmartOptions.mapping)


}

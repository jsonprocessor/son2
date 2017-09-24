package pl.writeonly.son2.drop.vaadin.complexes
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait


class SmartComp extends Complex {
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = ComplexPath.horizontalLayout(options, flags)
  setCompositionRoot(layout)
//  override def toComponent: Component = this
}

object SmartComp extends UITrait
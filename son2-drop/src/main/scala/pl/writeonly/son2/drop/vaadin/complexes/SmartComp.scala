package pl.writeonly.son2.drop.vaadin.complexes
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait


class SmartComp extends Complex {
  val options = new SmartOptionsComp
  val flags = new SmartFlagsComp
  val layout = ComplexPath.horizontalLayout(options.toComponent, flags.toComponent)
  override def toComponent: Component = layout
}

object SmartComp extends UITrait
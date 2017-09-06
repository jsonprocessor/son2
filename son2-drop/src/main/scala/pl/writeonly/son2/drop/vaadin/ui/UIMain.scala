package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui._
import pl.writeonly.son2.drop.vaadin.util.UITrait

@Title("Main UI")
@Theme("valo")
class UIMain extends UITrait {
  override def components: List[Component] = {
    return List[Component](linkPanel)
  }
}
package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui._

@Title("Main UI")
@Theme("valo")
class UIMain extends UITrait {
  override def components: List[Component] = {
    return List[Component](new TopMenu().linkPanel)
  }

}
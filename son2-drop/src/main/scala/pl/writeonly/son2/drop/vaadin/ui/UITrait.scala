package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.ui._

trait UITrait extends UIUtil {

  def components: List[Component]

  @Override
  override protected def init(vaadinRequest: VaadinRequest): Unit = {
    val layout = layoutVerticalLayout
    setContent(layout)
    layout.addComponents(components: _*)
  }

}

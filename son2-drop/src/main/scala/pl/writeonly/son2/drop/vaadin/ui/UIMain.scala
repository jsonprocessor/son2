package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.server.VaadinRequest
import com.vaadin.ui._

@Title("Main UI")
@Theme("valo")
class UIMain extends UITrait {

  @Override
  override protected def init(vaadinRequest: VaadinRequest) {
    val layout = new VerticalLayout()
    layout.setSpacing(true)
    layout.setMargin(true)
    layout.addComponent(link("Json Formatter", "formatter"))
    layout.addComponent(link("Json Converter", "converter"))
    layout.addComponent(link("Json Path", "path"))
    setContent(layout)

  }

}
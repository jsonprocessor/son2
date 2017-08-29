package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._

@Title("json converter")
@Theme("valo")
class UIConverter extends UI {

  @Override
  override protected def init(vaadinRequest: VaadinRequest) {

    val counterField = new TextArea("Counter", "N/A")
    counterField.setEnabled(true)

    val incrementButton = new Button("Increment", new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val count : Int = Option(getSession().getAttribute("count")).map(_.asInstanceOf[Int]).getOrElse(0)
        getSession().setAttribute("count", count+1)
        counterField.setValue(count.toString)
      }
    });

    val layout = new VerticalLayout()
    layout.setSpacing(true)
    layout.setMargin(true)
    layout.addComponent(counterField)
    layout.addComponent(incrementButton)
    setContent(layout)

  }

}
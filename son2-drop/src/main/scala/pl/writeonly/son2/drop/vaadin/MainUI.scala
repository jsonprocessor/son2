package pl.writeonly.son2.drop.vaadin

import com.google.common.base.MoreObjects
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout;

@Title("Main UI")
@Theme("valo")
class MainUI extends UI {

  @Override
  override protected def init( vaadinRequest: VaadinRequest) {

    val counterField = new TextField("Counter", "N/A")
    counterField.setEnabled(false)

    val incrementButton = new Button("Increment", new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val count : Int = MoreObjects.firstNonNull(getSession().getAttribute("count"), 0).asInstanceOf[Int]
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
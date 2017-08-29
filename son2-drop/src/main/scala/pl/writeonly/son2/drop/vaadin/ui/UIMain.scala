package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.server.{ExternalResource, VaadinRequest}
import com.vaadin.ui._
import com.vaadin.ui.Button.ClickEvent;

@Title("Main UI")
@Theme("valo")
class UIMain extends UI {

  @Override
  override protected def init(vaadinRequest: VaadinRequest) {

    val counterField = new TextField("Counter", "N/A")
    counterField.setEnabled(false)

    val incrementButton = new Button("Increment", new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val count : Int = Option(getSession().getAttribute("count")).map(_.asInstanceOf[Int]).getOrElse(0)
        getSession().setAttribute("count", count+1)
        counterField.setValue(count.toString)
      }
    });

    def link(caption: String, sourceURL : String) = new Link(caption ,new ExternalResource(sourceURL));

    val layout = new VerticalLayout()
    layout.setSpacing(true)
    layout.setMargin(true)
    layout.addComponent(link("Json Formatter", "formatter"))
    layout.addComponent(link("Json Converter", "converter"))
    layout.addComponent(link("Json Path", "path"))
    layout.addComponent(counterField)
    layout.addComponent(incrementButton)
    setContent(layout)

  }

}
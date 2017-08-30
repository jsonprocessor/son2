package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._

@Title("json converter")
@Theme("valo")
class UIConverter extends UITrait {

  @Override
  override protected def init(vaadinRequest: VaadinRequest) {

    val input = new TextArea("Input Json", "")
    input.setEnabled(true)
    input.setWidth("100%")

    val convert = new Button("Convert", new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val count : Int = Option(getSession().getAttribute("count")).map(_.asInstanceOf[Int]).getOrElse(0)
        getSession().setAttribute("count", count+1)
        input.setValue(count.toString)
      }
    })
    convert.setWidth("100%")

    val group = new RadioButtonGroup[String]("My Disabled Group");
    group.setItems("One", "Two", "Three");

    val output = new Label()
    output.setWidth("100%")

    val content = new FormLayout()
    val panel = new Panel("Provider", content)

    val layout = new VerticalLayout()
    layout.setSpacing(true)
    layout.setMargin(true)
    layout.addComponent(linkToBack)
    layout.addComponent(input)
    layout.addComponent(convert)
    layout.addComponent(output)

    setContent(layout)

  }

}
package pl.writeonly.son2.drop.vaadin.util

import java.util.Optional

import com.vaadin.server.ExternalResource
import com.vaadin.ui.{RadioButtonGroup, _}
import pl.writeonly.son2.drop.vaadin.util.JavaFunctions._

import scala.collection.JavaConverters._
import JavaFunctions._
import com.vaadin.shared.ui.ContentMode

trait UIUtil {

  def layoutVerticalLayout: VerticalLayout = {
    val result = new VerticalLayout()
    setWidth(result)
    result.setSpacing(true)
    result.setMargin(true)
    result
  }

  def horizontaPanel(caption: String, components: Component*) = new Panel(caption, new HorizontalLayout(components: _*))

  def horizontaPanelEx(caption: String, components: Component*): Panel = {
    val l = new HorizontalLayout()
    l.addComponentsAndExpand(components: _*)
    new Panel(caption, l)
  }


  def link(caption: String, sourceURL: String) = new Link(caption, new ExternalResource(sourceURL));


  def inputTextArea(caption: String): TextArea = {
    val result = new TextArea(caption)
    result.setEnabled(true)
    setWidth(result)
    result
  }

  def inputTextField(caption: String): TextField = {
    val result = new TextField(caption)
    result.setEnabled(true)
    setWidth(result)
    result
  }

  def optionsHorizontalLayout(components: List[Component]): HorizontalLayout = {
    new HorizontalLayout(components: _*)
  }

  def outputLabel: Label = {
    val result = new Label("", ContentMode.PREFORMATTED)
    setWidth(result)
    result
  }

  def setWidth(c: AbstractComponent) = c.setWidth("100%")

  def radioButtonGroup(caption: String, items: Map[String, _], selected: String): RadioButtonGroup[String] = radioButtonGroup(caption, items.keySet, selected)

  def radioButtonGroup(caption: String, items: Set[String], selected: String): RadioButtonGroup[String] = radioButtonGroup(caption, items.toList.sorted, selected)

  def radioButtonGroup(caption: String, items: Map[String, _]): RadioButtonGroup[String] = radioButtonGroup(caption, items.keySet)

  def radioButtonGroup(caption: String, items: Set[String]): RadioButtonGroup[String] = radioButtonGroup(caption, items.toList.sorted)

  def radioButtonGroup(caption: String, items: List[String]): RadioButtonGroup[String] = radioButtonGroup(caption, items, items.iterator.next)

  def radioButtonGroup(caption: String, items: List[String], selected: String): RadioButtonGroup[String] = {
    val result = new RadioButtonGroup[String](caption, items.asJavaCollection)
    result.setSelectedItem(selected)
    result
  }

  def selectedItem[A](group: RadioButtonGroup[String], mapping: Map[String, A]): A = getSelectedItem(group, mapping).get()

  def getSelectedItem[A](group: RadioButtonGroup[String], mapping: Map[String, A]): Optional[A] = group
    .getSelectedItem()
    .map((it: String) => mapping.get(it).get)

}

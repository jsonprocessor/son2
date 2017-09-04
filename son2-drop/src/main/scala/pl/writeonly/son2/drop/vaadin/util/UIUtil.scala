package pl.writeonly.son2.drop.vaadin.util

import java.util.Optional

import com.vaadin.server.ExternalResource
import com.vaadin.ui.{RadioButtonGroup, _}

import scala.collection.JavaConverters._
import JavaFunctions._

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



  def setWidth(c: AbstractComponent) = c.setWidth("100%")

  def optionsHorizontalLayout(components: List[Component]): HorizontalLayout = {
    new HorizontalLayout(components: _*)
  }

  def outputLabel: Label = {
    val result = new Label()
    setWidth(result)
    result
  }

  def radioButtonGroup(caption: String, items: Map[String, _], selected : String): RadioButtonGroup[String] = radioButtonGroup(caption, items.keySet, selected)

  def radioButtonGroup(caption: String, items: Map[String, _]): RadioButtonGroup[String] = radioButtonGroup(caption, items.keySet)

  def radioButtonGroup(caption: String, items: Iterable[String]): RadioButtonGroup[String] = radioButtonGroup(caption, items, items.iterator.next)

  def radioButtonGroup(caption: String, items: Iterable[String], selected: String): RadioButtonGroup[String] = {
    val result = new RadioButtonGroup[String](caption, items.asJavaCollection)
    result.setSelectedItem(selected)
    result
  }

  def getSelectedItem(group :RadioButtonGroup[String] , mapping : Map[String, Symbol]) : Optional[Symbol] = group
    .getSelectedItem()
    .map((it: String) => mapping.get(it).get)

  def selectedItem(group :RadioButtonGroup[String] , mapping : Map[String, Symbol]) = getSelectedItem(group, mapping).get()

}

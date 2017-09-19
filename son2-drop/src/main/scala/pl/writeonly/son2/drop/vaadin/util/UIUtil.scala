package pl.writeonly.son2.drop.vaadin.util

import java.util.Optional

import com.vaadin.server.ExternalResource
import com.vaadin.shared.ui.ContentMode
import com.vaadin.ui.{RadioButtonGroup, _}
import pl.writeonly.son2.drop.vaadin.util.JavaFunctions._

import scala.collection.JavaConverters._

trait UIUtil {

  def verticalLayout: VerticalLayout = {
    val result = new VerticalLayout()
    setWidth(result)
    result.setSpacing(true)
    result.setMargin(true)
    result
  }

  def setWidth(c: AbstractComponent) = c.setWidth("100%")

  def optionsHorizontalLayout(components: Seq[Component]): HorizontalLayout = {
    new HorizontalLayout(components: _*)
  }

  def verticalPanel(caption: String, components: Component*) = new Panel(caption, verticalLayout(components: _*))

  def verticalLayout(components: Component*) = setMargineFalse(new VerticalLayout(components: _*))

  def setMargineFalse(c: AbstractOrderedLayout) = {
    c.setMargin(false)
    c
  };

  def horizontalPanel(caption: String, components: Component*) = new Panel(caption, horizontalLayout(components: _*))

  def horizontalLayout(components: Component*) = setMargineFalse(new HorizontalLayout(components: _*))

  def horizontalPanelEx(caption: String, components: Component*): Panel = {
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

  def outputLabel: Label = {
    val result = new Label("", ContentMode.PREFORMATTED)
    setWidth(result)
    result
  }



  def checkBoxGroup(caption: String, items: Map[String, _]): CheckBoxGroup[String] = checkBoxGroup(caption, items.keySet)

  def checkBoxGroup(caption: String, items: Set[String]): CheckBoxGroup[String] = checkBoxGroup(caption, items.toList.sorted)

  def checkBoxGroup(caption: String, items: List[String]): CheckBoxGroup[String] = new CheckBoxGroup(caption, items.asJavaCollection)

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

  def checkBoxGroup2(caption: String, items: Set[ItemSymbol]): CheckBoxGroup[ItemSymbol] = checkBoxGroup2(caption, items.toList.sorted)

  def checkBoxGroup2(caption: String, items: List[ItemSymbol]): CheckBoxGroup[ItemSymbol] ={
    val result = new CheckBoxGroup(caption, items.asJavaCollection)
    result.setItemCaptionGenerator(new ItemCaptionGenerator[ItemSymbol](){
      override def apply(item: ItemSymbol): String = item.label
    })
    result
  }

  def radioButtonGroup2(caption: String, items: Set[ItemSymbol]): RadioButtonGroup[ItemSymbol] = radioButtonGroup2(caption, items.toList.sorted)

  def radioButtonGroup2(caption: String, items: List[ItemSymbol]): RadioButtonGroup[ItemSymbol] = radioButtonGroup(caption, items, items.iterator.next)

  def radioButtonGroup(caption: String, items: List[ItemSymbol], selected: ItemSymbol): RadioButtonGroup[ItemSymbol] = {
    val result = new RadioButtonGroup[ItemSymbol](caption, items.asJavaCollection)
    result.setSelectedItem(selected)
    result.setItemCaptionGenerator(new ItemCaptionGenerator[ItemSymbol](){
      override def apply(item: ItemSymbol): String = item.label
    })
    result
  }

  def selectedItem2(group: RadioButtonGroup[ItemSymbol]): ItemSymbol = group.getSelectedItem().get()

  def selectedItem[A](group: RadioButtonGroup[String], mapping: Map[String, A]): A = selectedItemOpt(group, mapping).get()

  def selectedItemOpt[A](group: RadioButtonGroup[String], mapping: Map[String, A]): Optional[A] = group
    .getSelectedItem()
    .map((it: String) => mapping.get(it).get)

  def selectedItem2(group: CheckBoxGroup[ItemSymbol]): Set[ItemSymbol] = group.getSelectedItems.asScala.toSet

  def selectedItem[A](group: CheckBoxGroup[String], mapping: Map[String, A]): Set[A] = group
    .getSelectedItems.asScala.toSet.map((it: String) => mapping.get(it).get)


}

package pl.writeonly.son2.drop.vaadin.util

import com.vaadin.server.ExternalResource
import com.vaadin.shared.ui.ContentMode
import com.vaadin.ui.{RadioButtonGroup, _}

import scala.collection.JavaConverters._

trait UIUtil {

  def verticalLayout: VerticalLayout = {
    val result = new VerticalLayout()
    setWidth(result)
    result.setSpacing(true)
    result.setMargin(true)
    result
  }

  def optionsHorizontalLayout(components: Seq[Component]): HorizontalLayout = {
    new HorizontalLayout(components: _*)
  }

  def verticalPanel(caption: String, components: Component*) = new Panel(caption, verticalLayout(components: _*))

  def verticalLayout(components: Component*) = setMargineFalse(new VerticalLayout(components: _*))

  def horizontalPanel(caption: String, components: Component*) = new Panel(caption, horizontalLayout(components: _*))

  def horizontalLayout(components: Component*) = setMargineFalse(new HorizontalLayout(components: _*))

  def setMargineFalse(c: AbstractOrderedLayout) = {
    c.setMargin(false)
    c
  };

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

  def setWidth(c: AbstractComponent) = c.setWidth("100%")

  def outputLabel: Label = {
    val result = new Label("", ContentMode.PREFORMATTED)
    setWidth(result)
    result
  }

  def checkBoxGroup(caption: String, items: List[String]): CheckBoxGroup[String] = new CheckBoxGroup(caption, items.asJavaCollection)

  def checkBoxGroup2(caption: String, items: Set[ItemSymbol]): CheckBoxGroup[ItemSymbol] = checkBoxGroup2(caption, items.toList.sorted)

  def checkBoxGroup2(caption: String, items: List[ItemSymbol]): CheckBoxGroup[ItemSymbol] = {
    val result = new CheckBoxGroup(caption, items.asJavaCollection)
    result.setItemCaptionGenerator(new ItemCaptionGenerator[ItemSymbol]() {
      override def apply(item: ItemSymbol): String = item.label
    })
    result
  }

  def radioButtonGroup2(caption: String, items: Set[ItemSymbol]): RadioButtonGroup[ItemSymbol] = radioButtonGroup2(caption, items.toList.sorted)

  def radioButtonGroup2(caption: String, items: List[ItemSymbol]): RadioButtonGroup[ItemSymbol] = radioButtonGroup2(caption, items, items.iterator.next)

  def radioButtonGroup2(caption: String, items: List[ItemSymbol], selected: ItemSymbol): RadioButtonGroup[ItemSymbol] = {
    val result = new RadioButtonGroup[ItemSymbol](caption, items.asJavaCollection)
    result.setSelectedItem(selected)
    result.setItemCaptionGenerator(new ItemCaptionGenerator[ItemSymbol]() {
      override def apply(item: ItemSymbol): String = item.label
    })
    result
  }

  def radioButtonGroup2(caption: String, items: Set[ItemSymbol], selected: ItemSymbol): RadioButtonGroup[ItemSymbol] = radioButtonGroup2(caption, items.toList.sorted, selected)

  def selectedItem2(group: RadioButtonGroup[ItemSymbol]): ItemSymbol = group.getSelectedItem().get()

  def selectedItem2(group: CheckBoxGroup[ItemSymbol]): Set[ItemSymbol] = group.getSelectedItems.asScala.toSet

}

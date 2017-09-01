package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.{CheckBoxGroup, _}
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.glue.Streamers

import scala.collection.JavaConverters._

trait UITrait extends UIUtil {

  val natives = List("Print", "String")

  def components: List[Component]

  def nativeGroup = new CheckBoxGroup("Native:", natives.asJavaCollection)

  def debug(configLabel : Label, config: Config, set: Set[String]) =  configLabel.setValue(config.toString + "\n" + set)

  def convert2(provider: Converter, input: TextArea, output: Label, items: Set[String]) = {
    val inputValue = input.getValue
    val streamer = Streamers.print(items.contains("Print"), false, provider)
    val outputValue = streamer.convertString(items.contains("String"), inputValue)
    output.setValue(outputValue)
  }



  @Override
  override protected def init(vaadinRequest: VaadinRequest): Unit = {
    val layout = layoutVerticalLayout
    setContent(layout)
    layout.addComponents(components: _*)
  }

}

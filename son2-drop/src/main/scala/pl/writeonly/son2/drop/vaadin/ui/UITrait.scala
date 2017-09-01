package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.ui._
import pl.writeonly.son2.core.glue.Streamers
import pl.writeonly.son2.core.providers.Provider

trait UITrait extends UIUtil {

  def components: List[Component]

  @Override
  override protected def init(vaadinRequest: VaadinRequest): Unit = {
    val layout = layoutVerticalLayout
    setContent(layout)
    layout.addComponents(components: _*)
  }

  def convert2(provider: Provider, input:TextArea, output:Label, items : Set[String]) = {
    val inputValue = input.getValue
    val streamer = Streamers.print(items.contains("Print"),false, provider)
    val outputValue = streamer.convertString(items.contains("String"),inputValue)
    output.setValue(outputValue)
  }

}

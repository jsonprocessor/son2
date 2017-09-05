package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import org.json.JSONException
import org.skyscreamer.jsonassert.{JSONAssert, JSONCompare, JSONCompareMode, JSONCompareResult}
import pl.writeonly.son2.drop.vaadin.util.Mappings
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.glue.CreatorConverterPath

import scala.collection.JavaConverters._
import scala.util.Try
import scala.util.control.Exception.catching

@Title("json path")
@Theme("valo")
class UIComparator extends UITrait {

//  val modeGroup =


  override def components: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val inputLeft = inputTextArea("expected json:")
    val inputRight = inputTextArea("actual json:")
    val output = outputLabel

    val modeGroup = radioButtonGroup("Compare mode", Mappings.modeMapping)
    val outputFormats = jacksonOutputFormat("JSON")
    val components: List[Component] = List(modeGroup)


    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val mode = selectedItem(modeGroup, Mappings.modeMapping)
//        JSONAssert.assertEquals(inputLeft.getValue, inputRight.getValue, mode)
        val result: Either[Throwable, JSONCompareResult] = catching(classOf[Exception])
          .either(JSONCompare.compareJSON(inputLeft.getValue, inputRight.getValue, mode))
        val value = result match {
          case Right(result) => result.toString
          case Left(exception) => exception.getMessage
        }
        output.setValue(value)


      }
    });

    return List(linkPanel, optionsPanel(components), inputLeft, inputRight, convert, output)
  }
}
package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging
import com.google.gson.JsonParser
import org.yaml.snakeyaml.Yaml

class Son2Other extends Liner {
  override def convert(jsonString: String): String = {
    val jsonObject = new JsonParser().parse(jsonString).getAsJsonObject()
    new Yaml().dump(jsonObject)
  }

  override def comment(jsonString:String) = "#" + jsonString + "\n"
}

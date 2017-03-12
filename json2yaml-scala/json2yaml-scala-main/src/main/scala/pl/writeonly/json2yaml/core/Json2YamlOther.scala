package pl.writeonly.json2yaml.core

import com.google.gson.JsonParser
import org.yaml.snakeyaml.Yaml
import pl.writeonly.json2yaml.util.AppLogging

object Json2YamlOther extends AppLogging {
  new FileJson2YamlSource(new Json2YamlOther).convertFile(args(0), args(1))
}

class Json2YamlOther extends Json2Yaml {
  override protected def apply(jsonString: String): String = {
    val jsonObject = new JsonParser().parse(jsonString).getAsJsonObject()
    new Yaml().dump(jsonObject)
  }
}

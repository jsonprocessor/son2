package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging
import com.google.gson.JsonParser
import org.yaml.snakeyaml.Yaml


object Json2YamlOther extends AppLogging {
  new FileJson2YamlSource(new Json2YamlOther).convertFile(args(0), args(1))
}

class Json2YamlOther extends Json2Yaml {
  override protected def apply(jsonString: String): String = {
    val jsonObject = new JsonParser().parse(jsonString).getAsJsonObject()
    new Yaml().dump(jsonObject)
  }
}

package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging
import com.google.gson.JsonParser
import org.yaml.snakeyaml.Yaml


object Son2Other extends AppLogging {
  new FileSon2Source(new Son2Other).convertFile(args(0), args(1))
}

class Son2Other extends Son2 {
  override protected def apply(jsonString: String): String = {
    val jsonObject = new JsonParser().parse(jsonString).getAsJsonObject()
    new Yaml().dump(jsonObject)
  }
}

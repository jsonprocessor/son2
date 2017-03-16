package pl.writeonly.son2.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.util.AppLogging

object Son2Yaml extends AppLogging {
  new FileSon2Source(new Son2Yaml).convertFile(args(0), args(1))
}

class Son2Yaml extends Son2 {
  override protected def apply(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
    new YAMLMapper().writeValueAsString(jsonNodeTree)
  }
}

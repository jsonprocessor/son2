package pl.writeonly.json2yaml.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.json2yaml.util.AppLogging

object Json2YamlJackson extends AppLogging {
  new FileJson2YamlSource(new Json2YamlJackson).convertFile(args(0), args(1))
}

class Json2YamlJackson extends Json2Yaml {
  override protected def apply(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
    new YAMLMapper().writeValueAsString(jsonNodeTree)
  }
}

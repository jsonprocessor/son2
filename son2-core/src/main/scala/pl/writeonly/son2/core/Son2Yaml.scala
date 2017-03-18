package pl.writeonly.son2.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper

class Son2Yaml extends Son2 {
  override def apply(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
    new YAMLMapper().writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString:String) = "#" + jsonString + "\n"
}

package pl.writeonly.son2.core

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper

class Son2Pretty extends Son2 {
  override def convert(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
    new ObjectMapper().setDefaultPrettyPrinter(new DefaultPrettyPrinter).writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString: String) = "#" + jsonString
}

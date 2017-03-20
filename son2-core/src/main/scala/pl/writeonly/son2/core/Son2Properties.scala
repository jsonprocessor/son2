package pl.writeonly.son2.core

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper


class Son2Properties extends Son2 {
  override def convert(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
//    new JavaPropsMapper().setDefaultPrettyPrinter(new DefaultPrettyPrinter).writeValueAsString(jsonNodeTree)
    new JavaPropsMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString: String) = "#" + jsonString
}

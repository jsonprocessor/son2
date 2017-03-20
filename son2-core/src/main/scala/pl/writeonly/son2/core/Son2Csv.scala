package pl.writeonly.son2.core

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper

class Son2Csv extends Son2 {
  override def convert(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
//    new CsvMapper().setDefaultPrettyPrinter(new DefaultPrettyPrinter).writeValueAsString(jsonNodeTree)
    new CsvMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString: String) = "#" + jsonString + "\n"
}


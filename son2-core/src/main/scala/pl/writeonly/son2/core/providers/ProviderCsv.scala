package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper

class ProviderCsv(in:ObjectMapper) extends Provider(in, new CsvMapper()) {

  override def comment(s: String) = "#" + s
}


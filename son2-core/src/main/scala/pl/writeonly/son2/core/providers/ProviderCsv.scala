package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import pl.writeonly.son2.core.formats.Config

class ProviderCsv(config : Config) extends Provider(config, new CsvMapper()) {

  override def comment(s: String) = "#" + s
}


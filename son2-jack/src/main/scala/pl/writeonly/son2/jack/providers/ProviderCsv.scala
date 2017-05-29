package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import pl.writeonly.son2.jack.core.Config

class ProviderCsv(config: Config) extends ProviderJack(config, new CsvMapper()) {

  override def comment(s: String) = "#" + s
}


package pl.writeonly.son2.impl.core.providers

import com.fasterxml.jackson.dataformat.csv.CsvMapper

class ProviderCsv extends Provider(new CsvMapper()) {

  override def comment(s: String) = "#" + s
}


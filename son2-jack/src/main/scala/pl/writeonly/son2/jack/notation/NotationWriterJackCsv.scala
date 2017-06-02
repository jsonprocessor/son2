package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.dataformat.csv.CsvMapper

class NotationWriterJackCsv(val pretty: Boolean)
  extends NotationWriterJack(pretty, new CsvMapper()) {

  override def comment(s: String) = "#" + s
}

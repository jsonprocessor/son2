package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderCsv, NotationWriterJack}

class PartialCreatorCsv(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.CSV

  override def r(s: String) = new NotationReaderCsv

  override def w(s: String) = new NotationWriterJack(pretty, new CsvMapper, "#", "")
}

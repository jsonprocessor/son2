package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderCsv, NotationWriterJack}

class PartialCreatorCsv(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.CSV

  override def r(c: Config) = new NotationReaderCsv

  override def w(c: Config) = new NotationWriterJack(pretty, new CsvMapper, "#", "")
}

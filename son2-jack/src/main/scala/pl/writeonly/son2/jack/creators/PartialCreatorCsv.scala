package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderCsv, NotationWriterJack}

class PartialCreatorCsv(pretty: Boolean) extends PartialCreatorJack {
  def format = Formats.CSV

  def r = new NotationReaderCsv

  def w = new NotationWriterJack(pretty, new CsvMapper, "#", "")
}

package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class PartialCreatorCsv(pretty: Boolean) extends PartialCreatorPair {
  def startsWith = Formats.CSV
  def r = new NotationReaderJack(new CsvMapper)
  def w = new NotationWriterJack(pretty, new CsvMapper, "#", "")
}

package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class PartialCreatorYaml(pretty: Boolean) extends PartialCreatorPair {
  def startsWith = Formats.YAML
  def r = new NotationReaderJack(new YAMLMapper)
  def w = new NotationWriterJack(pretty, new YAMLMapper, "#", "")
}

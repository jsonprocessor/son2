package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderYaml, NotationWriterJack}

class PartialCreatorYaml(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.YAML

  override def r(s: String) = new NotationReaderYaml

  override def w(s: String) = new NotationWriterJack(pretty, new YAMLMapper, "#", "")
}

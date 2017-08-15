package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderYaml, NotationWriterJack}

class PartialCreatorYaml(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.YAML

  override def r(c: Config) = new NotationReaderYaml

  override def w(c: Config) = new NotationWriterJack(pretty, new YAMLMapper, "#", "")
}

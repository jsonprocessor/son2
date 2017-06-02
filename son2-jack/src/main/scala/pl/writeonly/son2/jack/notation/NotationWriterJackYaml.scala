package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper

class NotationWriterJackYaml(val pretty: Boolean)
  extends NotationWriterJack(pretty, new YAMLMapper()) {

  override def comment(s: String) = "#" + s
}

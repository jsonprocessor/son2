package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.formats.matchers.ChainCreator
import pl.writeonly.son2.jack.creators._

class ChainCreatorJack(pretty: Boolean) extends ChainCreator {

  def get = (
    new PartialCreatorObject(pretty)
      orElse
      new PartialCreatorXml(pretty)
      orElse
      new PartialCreatorYaml(pretty)
      orElse
      new PartialCreatorCsv(pretty)
      orElse
      new PartialCreatorJavaProps(pretty)
      orElse
      new PartialCreatorProperties(pretty)
    )

}

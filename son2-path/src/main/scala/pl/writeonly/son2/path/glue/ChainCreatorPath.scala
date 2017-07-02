package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.formats.matchers.ChainCreator
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class ChainCreatorPath(pretty: Boolean) extends ChainCreator {

  def get = (
    new PartialCreatorPath
      orElse
      new PartialCreatorSmart(pretty)
      orElse
      new PartialCreatorStrict(pretty)
    )

}

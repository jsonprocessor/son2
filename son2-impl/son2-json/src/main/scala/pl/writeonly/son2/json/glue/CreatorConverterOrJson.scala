package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorConverterOr

class CreatorConverterOrJson
    extends CreatorConverterOr(new ChainNotationConfigJson().get,
                               new ChainNotationRWTJson()) {
  override def configOpt(s: String): Option[Config] =
    chainNotationCreator.configOpt(s) match {
      case c: Some[Config] => c
      //    case None => new ChainReaderJack().configOpt(s)
    }
}

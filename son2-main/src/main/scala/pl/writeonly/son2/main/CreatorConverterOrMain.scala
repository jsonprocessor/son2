package pl.writeonly.son2.main

import pl.writeonly.son2.core.chain.ChainNotationRWT
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorConverterOr
import pl.writeonly.son2.jack.chain.ChainReaderJack
import pl.writeonly.son2.jack.glue.{
  ChainNotationConfigJack,
  ChainNotationRWTJack
}
import pl.writeonly.son2.path.glue.{
  ChainNotationConfigPathMain,
  ChainNotationRWTPath
}
import pl.writeonly.son2.text.creators.PCreatorConfigText
import pl.writeonly.son2.text.glue.ChainNotationRWTText

class CreatorConverterOrMain
    extends CreatorConverterOr(
      new ChainNotationConfigPathMain().get
        orElse
          new ChainNotationConfigJack().get
        orElse
          new PCreatorConfigText,
      new ChainNotationRWT(
        new ChainNotationRWTPath().r
          orElse
            new ChainNotationRWTJack().r
          orElse
            new ChainNotationRWTText().r,
        new ChainNotationRWTPath().w
          orElse
            new ChainNotationRWTJack().w
          orElse
            new ChainNotationRWTText().w,
        new ChainNotationRWTPath().t
          orElse
            new ChainNotationRWTJack().t
          orElse
            new ChainNotationRWTText().t
      )
    ) {
  override def configOpt(s: String): Option[Config] =
    chainNotationCreator.configOpt(s).orElse(new ChainReaderJack().configOpt(s))

}

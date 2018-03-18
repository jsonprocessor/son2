package pl.writeonly.son2.main

import pl.writeonly.son2.core.chain.ChainNotationRWT
import pl.writeonly.son2.core.config.RWTConfig
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
      new ChainNotationConfigJack().get
        orElse
          new ChainNotationConfigPathMain().get
        orElse
          new PCreatorConfigText,
      new ChainNotationRWT(
        new ChainNotationRWTJack().r
          orElse
            new ChainNotationRWTPath().r
          orElse
            new ChainNotationRWTText().r,
        new ChainNotationRWTJack().w
          orElse
            new ChainNotationRWTPath().w
          orElse
            new ChainNotationRWTText().w,
        new ChainNotationRWTJack().t
          orElse
            new ChainNotationRWTPath().t
          orElse
            new ChainNotationRWTText().t
      )
    ) {
  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s).orElse(new ChainReaderJack().configOpt(s))

}

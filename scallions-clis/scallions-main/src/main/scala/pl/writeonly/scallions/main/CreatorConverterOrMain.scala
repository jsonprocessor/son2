package pl.writeonly.scallions.main

import pl.writeonly.scallions.apis.chain.ChainNotationRWT
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.funs.glue.CreatorConverterOr
import pl.writeonly.scallions.jack.chain.ChainReaderJack
import pl.writeonly.scallions.jack.glue.{
  ChainNotationConfigJack,
  ChainNotationRWTJack
}
import pl.writeonly.scallions.path.glue.{
  ChainNotationConfigPathMain,
  ChainNotationRWTPath
}
import pl.writeonly.scallions.text.creators.PCreatorConfigText
import pl.writeonly.scallions.text.glue.ChainNotationRWTText

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

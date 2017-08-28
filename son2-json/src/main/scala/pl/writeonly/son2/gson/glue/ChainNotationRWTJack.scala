package pl.writeonly.son2.gson.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.gson.creators.{PCreatorReaderGson, PCreatorWriterGson}

class ChainNotationRWTJack extends ChainNotationRWT(
  new PCreatorReaderGson(),
  new PCreatorWriterGson(),
  new PCreatorTranslatorFake()
)
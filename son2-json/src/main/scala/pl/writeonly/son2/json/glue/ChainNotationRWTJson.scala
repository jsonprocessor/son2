package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.json.creators.{PCreatorReaderGson, PCreatorWriterGson}

class ChainNotationRWTJson extends ChainNotationRWT(
  new PCreatorReaderGson(),
  new PCreatorWriterGson(),
  new PCreatorTranslatorFake()
)
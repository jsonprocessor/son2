package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorReaderFake, PCreatorWriterFake}
import pl.writeonly.son2.text.creators.PCreatorTranslatorText

class ChainNotationRWTText extends ChainNotationRWT(
  new PCreatorReaderFake(),
  new PCreatorWriterFake(),
  new PCreatorTranslatorText()
)

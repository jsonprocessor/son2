package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.{ Config, RConfig, WConfig }
import pl.writeonly.son2.core.notation.{
  NotationReader,
  NotationTranslator,
  NotationWriter
}
import pl.writeonly.son2.core.pcreators.{
  PCreatorReader,
  PCreatorTranslator,
  PCreatorWriter
}

class ChainNotationRWT(
  val r: PCreatorReader,
  val w: PCreatorWriter,
  val t: PCreatorTranslator)

class PCreatorReaderFake extends PCreatorReader {
  override def isDefinedAt(x: RConfig): Boolean = false

  override def apply(c: RConfig): NotationReader =
    throw new IllegalStateException(c.toString)
}

class PCreatorReaderSymbol(format: Symbol, creator: RConfig => NotationReader)
  extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean =
    format.name.startsWith(c.provider.name)

  override def apply(c: RConfig): NotationReader = creator(c)
}

class PCreatorWriterFake extends PCreatorWriter {
  override def isDefinedAt(x: WConfig): Boolean = false

  override def apply(c: WConfig): NotationWriter =
    throw new IllegalStateException(c.toString)
}

class PCreatorWriterSymbol(format: Symbol, creator: WConfig => NotationWriter)
  extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean =
    format.name.startsWith(c.provider.name)

  override def apply(c: WConfig): NotationWriter = creator(c)
}

class PCreatorTranslatorFake extends PCreatorTranslator {
  override def isDefinedAt(x: Config): Boolean = false

  override def apply(c: Config): NotationTranslator =
    throw new IllegalStateException(c.toString)
}

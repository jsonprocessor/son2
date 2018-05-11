package pl.writeonly.son2.apis.notation

final case class NotationRWT(r: NotationReaderLike,
                             w: NotationWriter,
                             t: NotationTranslator)

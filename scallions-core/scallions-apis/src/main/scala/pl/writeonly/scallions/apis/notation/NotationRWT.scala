package pl.writeonly.scallions.apis.notation

final case class NotationRWT(r: NotationReaderLike,
                             w: NotationWriter,
                             t: NotationTranslator)

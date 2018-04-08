package pl.writeonly.son2.apis.notation

case class NotationRWT(r: NotationReaderLike,
                       w: NotationWriter,
                       t: NotationTranslator)

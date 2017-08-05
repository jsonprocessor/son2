package pl.writeonly.son2.core.chain

class ChainImpl[F](val get: PartialFunction[String, F])

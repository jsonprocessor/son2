package pl.writeonly.son2.apis.chain

class ChainImpl[F](val get: PartialFunction[String, F])

package pl.writeonly.scallions.apis.chain

class ChainImpl[F](val get: PartialFunction[String, F])

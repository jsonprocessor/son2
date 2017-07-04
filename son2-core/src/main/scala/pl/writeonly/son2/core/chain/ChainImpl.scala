package pl.writeonly.son2.core.chain

class ChainImpl[F](chain: PartialFunction[String, F]) extends Chain[F] {

  def get = chain
}

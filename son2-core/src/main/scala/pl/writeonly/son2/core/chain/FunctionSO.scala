package pl.writeonly.son2.core.chain

trait FunctionSO[F] {
  def apply(s: String): Option[F]
}

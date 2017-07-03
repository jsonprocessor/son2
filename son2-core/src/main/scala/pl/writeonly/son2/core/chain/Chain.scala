package pl.writeonly.son2.core.chain

trait Chain[F] extends FunctionSO[F] {
  def apply(s: String): Option[F] = get.lift(s)

  def get: PartialFunction[String, F]
}

package pl.writeonly.son2.jack.formats.predicates

trait PredicateFormat[F] {

  def left(s: String): Either[Option[String], F] = Left(Option(s))

  def on(s: String): Boolean

  def yaml(s: String): Boolean

  def xml(s: String): Boolean

  def csv(s: String): Boolean

  def javaprops(s: String): Boolean

  def properties(s: String): Boolean

}

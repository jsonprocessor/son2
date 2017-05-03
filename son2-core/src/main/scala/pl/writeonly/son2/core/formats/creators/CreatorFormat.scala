package pl.writeonly.son2.core.formats.creators

trait CreatorFormat[F] {
  def on: F
  def yaml: F
  def xml: F
  def csv: F
  def javaprops: F
}

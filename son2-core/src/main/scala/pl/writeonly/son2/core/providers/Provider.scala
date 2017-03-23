package pl.writeonly.son2.core.providers

trait Provider {
  def convert(s: String) : String

  def comment(s: String) : String
}

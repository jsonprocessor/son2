package pl.writeonly.scallions.text.creators

import pl.writeonly.scallions.apis.config.TConfig
import pl.writeonly.scallions.apis.core.core.DString
import pl.writeonly.scalaops.pipe.Pipe._

trait Matcher {

  type PF = PartialFunction[TConfig, Transformer]

  type Transformer

  def apply(c: TConfig): DString = c |> pf |> extract

  def pf: PF

  def extract(d: Transformer): DString
}

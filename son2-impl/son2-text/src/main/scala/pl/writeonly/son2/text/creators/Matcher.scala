package pl.writeonly.son2.text.creators

import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.apis.core.core.DString
import pl.writeonly.scalaops.pipe.Pipe._

trait Matcher {

  type PF = PartialFunction[TConfig, Transformer]

  type Transformer

  def apply(c: TConfig): DString = c |> pf |> extract

  def pf: PF

  def extract(d: Transformer): DString
}

package pl.writeonly.son2.text.creators

import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.apis.core.core.DString

trait Matcher {

  type PF = PartialFunction[TConfig, Transformer]

  type Transformer

  def apply(p: TConfig): DString = extract(pf(p))

  def extract(d: Transformer): DString

  def pf: PF
}

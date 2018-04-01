package pl.writeonly.son2.rison

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hronom.jackson.dataformat.rison.{
  RisonFactory,
  RisonGenerator,
  RisonParser
}
import pl.writeonly.son2.apis.config.RWTConfig

import pl.writeonly.sons.utils.ops.Pipe._
import pl.writeonly.son2.hocon.ConfigOptHocon

class ConfigOptRison extends ConfigOptHocon {

  override def config(s: String): RWTConfig = s |> rison2json |> super.config

  def rison2json(s: String): String =
    s |> rison.readTree |> new ObjectMapper().writeValueAsString

  def rison: ObjectMapper =
    new RisonFactory()
      .enable(RisonGenerator.Feature.O_RISON)
      .enable(RisonParser.Feature.O_RISON) |> factory

}

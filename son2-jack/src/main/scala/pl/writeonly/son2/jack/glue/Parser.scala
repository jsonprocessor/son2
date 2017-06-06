package pl.writeonly.son2.jack.glue

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import pl.writeonly.son2.core.glue.Config

class Parser {
  val mapper = new ObjectMapper()
  //  val module = new OptionModule with TupleModule {}
  mapper.registerModule(DefaultScalaModule)

  def apply(json: String): Config = mapper.readValue(json, classOf[Config])
}

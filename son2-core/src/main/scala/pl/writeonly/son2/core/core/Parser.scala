package pl.writeonly.son2.core.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, OptionModule, TupleModule}

class Parser {
  val mapper = new ObjectMapper()
//  val module = new OptionModule with TupleModule {}
  mapper.registerModule(DefaultScalaModule)

  def config(json:String):Config = mapper.readValue(json, classOf[Config])
}

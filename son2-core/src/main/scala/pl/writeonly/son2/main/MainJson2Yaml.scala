package pl.writeonly.son2.main

import pl.writeonly.son2.core.{FileJson2Yaml, FileJson2YamlImpl, Json2YamlJackson}
import pl.writeonly.son2.util.AppLogging

object MainJson2Yaml extends AppLogging {
  val YAML  = ".yaml"

  val onml = new Json2YamlJackson
  val file = new FileJson2YamlImpl(onml)
  val main = new MainJson2Yaml(file)

  args.length match {
    case 0 => main.convertFile()
    case 1 => main.convertFile(args(0))
    case _ => main.convertFile(args(0), args(1))
  }

}

class MainJson2Yaml(val file : FileJson2Yaml) {

  def convertFile(in: String, out:String):Unit = file.convertFile(in, out)

  //FIXME
  def convertFile(in: String):Unit = convertFile(in, in + MainJson2Yaml.YAML)

  def convertFile():Unit = file.convertStream(System.in, System.out)

}

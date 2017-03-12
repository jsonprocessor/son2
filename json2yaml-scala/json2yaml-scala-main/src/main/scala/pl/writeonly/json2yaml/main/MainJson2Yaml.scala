package pl.writeonly.json2yaml.main

import pl.writeonly.json2yaml.core.{FileJson2Yaml, FileJson2YamlImpl, Json2YamlJackson}
import pl.writeonly.json2yaml.util.AppLogging

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

  def convertFile(in: String):Unit = convertFile(in, in + MainJson2Yaml.YAML)

  def convertFile():Unit = file.convertStream(System.in, System.out)

}

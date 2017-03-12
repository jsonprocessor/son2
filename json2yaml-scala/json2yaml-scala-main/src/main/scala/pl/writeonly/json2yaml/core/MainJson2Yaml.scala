package pl.writeonly.json2yaml.core

object MainJson2Yaml {
  val YAML  = ".yaml"
}

class MainJson2Yaml(val onml : FileJson2Yaml) {

  def convertFile(in: String, out:String):Unit = onml.convertFile(in, out)

  def convertFile(in: String):Unit = convertFile(in, in + MainJson2Yaml.YAML)

  def convertFile():Unit = onml.convertStream(System.in, System.out)



}

package pl.writeonly.son2.main

import pl.writeonly.son2.core.{FileSon2, FileSon2Impl, Son2Yaml}
import pl.writeonly.son2.util.AppLogging

object MainSon2 extends AppLogging {
  val YAML  = ".yaml"

  val onml = new Son2Yaml
  val file = new FileSon2Impl(onml)
  val main = new MainSon2(file)

  args.length match {
    case 0 => main.convertFile()
    case 1 => main.convertFile(args(0))
    case _ => main.convertFile(args(0), args(1))
  }

}

class MainSon2(val file : FileSon2) {

  def convertFile(in: String, out:String):Unit = file.convertFile(in, out)

  //FIXME
  def convertFile(in: String):Unit = convertFile(in, in + MainSon2.YAML)

  def convertFile():Unit = file.convertStream(System.in, System.out)

}

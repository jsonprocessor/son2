package pl.writeonly.son2.main

import java.io.FileInputStream

import pl.writeonly.son2.core._
import pl.writeonly.son2.util.AppLogging

object MainSon2 extends AppLogging {

  val YAML = ".yaml"

  val son2 = args.length match {
    case 0 => Option.empty
    case _ => args(0) match {
      case "y" => Option(new Son2Yaml)
      case "x" => Option(new Son2Xml)
      case _ => Option.empty
    }
  }

  son2.map(s => {
    val file = new FileSon2Impl(s)
    val source = new FileSon2Source(s)
    args.length match {
      case 1 => file.convertStream(System.in, System.out)
      case 2 => source.convertStream(new FileInputStream(args(1)), System.out)
      case _ => file.convertFile(args(1), args(2))
    }
  }).getOrElse(() => {
    val source = new FileSon2Source(new Son2)
    source.convertStream(getClass.getResourceAsStream("help"), System.out)
  })
}

class MainSon2(file : FileSon2Impl) {
  def convertStream() = file.convertStream(System.in, System.out)
  def convertFile(in : String) = file.convertFile(in, in + MainSon2.YAML)
  def convertFile(in : String, out:String) = file.convertFile(in, out)

}


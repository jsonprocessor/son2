package pl.writeonly.son2.main

import java.io.FileInputStream

import pl.writeonly.son2.core._
import pl.writeonly.son2.core.providers._
import pl.writeonly.son2.core.file.{StreamerImpl, StreamerSource}
import pl.writeonly.son2.util.AppLogging

object MainSon2 extends AppLogging {

  val YAML = ".yaml"

  val son2 = args.length match {
    case 0 => Option.empty
    case _ => args(0).toLowerCase match {
      case o if ("object".startsWith(o)) => Option(new Son2Object)
      case y if ("yaml".startsWith(y)) => Option(new Son2Yaml)
      case x if ("xml".startsWith(x)) => Option(new Son2Xml)
      case c if ("csv".startsWith(c)) => Option(new Son2Csv)
      case p if ("properties".startsWith(p)) => Option(new Son2Properties)
      case _ => Option.empty
    }
  }

  son2.map { s =>
    val file = new StreamerImpl(s)
    val source = new StreamerSource(s)
    args.length match {
      case 1 => file.convertStream(System.in, System.out)
      case 2 => source.convertStream(new FileInputStream(args(1)), System.out)
      case _ => file.convertFile(args(1), args(2))
    }
  }.getOrElse {
    val file = new StreamerSource(new Liner)
    val in = getClass().getClassLoader().getResourceAsStream("README.md")
    file.convertStream(in, System.out)
  }
}

class MainSon2(file: StreamerImpl) {
  def convertStream() = file.convertStream(System.in, System.out)

  def convertFile(in: String) = file.convertFile(in, in + MainSon2.YAML)

  def convertFile(in: String, out: String) = file.convertFile(in, out)

}


package pl.writeonly.son2.funs.glue

import java.io.{FileInputStream, InputStream}

import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.streamers.Streamer

class Piper(params: Params, converter: Converter) {

  def right(args: Array[String]): Unit = args.length match {
    case 0 => convertStream()
    case 1 => convertFile(args(0))
    case _ => convertFile(args(0), args(1))
  }

  def convertStream(): Unit = pipe.convertStream(params.in, params.out)

  def pipe: Streamer = Streamers.pipe(converter.config.read.stream, converter)

  def convertFile(in: String, out: String): Unit = pipe.convertFile(in, out)

  def convertFile(in: String): Unit = in match {
    case "." => println(converter.config)
    case _   => convertStream(new FileInputStream(in))
  }

  def convertStream(in: InputStream): Unit =
    source.convertStream(in, params.out)

  def source: Streamer =
    Streamers.source(converter.config.read.stream, converter)

  def print(print: Boolean): Streamer =
    Streamers.print(print, converter.config.read.stream, converter)

  def convertResource(name: String): Unit =
    convertStream(resourceAsStream(name))

  def resourceAsStream(name: String): InputStream =
    getClass().getClassLoader().getResourceAsStream(name)

}

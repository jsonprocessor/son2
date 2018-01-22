package pl.writeonly.son2.core.glue

import java.io.{FileInputStream, InputStream}

import pl.writeonly.son2.core.converters.Converter

class Piper(params: Params, converter: Converter) {

  def right(args: Array[String]) = args.length match {
    case 0 => convertStream();
    case 1 => convertFile(args(0));
    case _ => convertFile(args(0), args(1));
  }

  def convertStream() = pipe.convertStream(params.in, params.out)

  def pipe = Streamers.pipe(converter.config.read.stream, converter)

  def convertFile(in: String, out: String) = pipe.convertFile(in, out)

  def convertFile(in: String) = convertStream(new FileInputStream(in))

  def convertStream(in: InputStream) = source.convertStream(in, params.out)

  def source = Streamers.source(converter.config.read.stream, converter)

  def print(print: Boolean) =
    Streamers.print(print, converter.config.read.stream, converter)

  def convertResource(name: String) = convertStream(resourceAsStream(name))

  def resourceAsStream(name: String) =
    getClass().getClassLoader().getResourceAsStream(name)

}

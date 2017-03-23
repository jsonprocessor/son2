package pl.writeonly.son2.core.file

import java.io._
import java.net.URI

import pl.writeonly.son2.core.Liner

object Streamer {
  val UTF_8 = "UTF-8"
}

abstract class Streamer(val son2: Liner) {

  def convertFile(in: String, out: String): Unit = convertFile(new File(in), new File(out))

  def convertFile(in: URI, out: URI): Unit

  def convertFile(in: File, out: File): Unit

  def convertString(in: String): String = {
    Option(in).map { s =>
      val bytes = convertBytes(in.getBytes(Streamer.UTF_8))
      new String(bytes, Streamer.UTF_8)
    }.orNull
  }

  def convertStringNative(in: String): String

  def convertBytes(in: Array[Byte]): Array[Byte]

  def convertStream(in: InputStream, out: OutputStream): Unit

  protected def appendLine(out: Writer, line: String): Unit = {
    val yaml = son2.applyTry(line)
    out.append(yaml)
  }

  protected def appendLine(out: StringBuilder, line: String): Unit = {
    val yaml = son2.applyTry(line)
    out.append(yaml)
  }
}



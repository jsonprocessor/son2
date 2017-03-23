package pl.writeonly.son2.core.streamers

import java.io._
import java.net.URI

import pl.writeonly.son2.core.liners.Liner
import pl.writeonly.son2.util.Control

abstract class Streamer(val liner: Liner) {

  def convertFile(in: String, out: String): Unit = convertFile(new File(in), new File(out))

  def convertFile(in: URI, out: URI): Unit

  def convertFile(in: File, out: File): Unit

  def convertString(in: String): String = {
    Option(in).map { s =>
      val bytes = convertBytes(in.getBytes(Control.UTF_8))
      new String(bytes, Control.UTF_8)
    }.orNull
  }

  def convertStringNative(in: String): String

  def convertBytes(in: Array[Byte]): Array[Byte]

  def convertStream(in: InputStream, out: OutputStream): Unit

  protected def appendLine(out: Writer, line: String): Unit = {
    val result = liner.apply(line)
    out.append(result)
  }

  protected def appendLine(out: StringBuilder, line: String): Unit = {
    val result = liner.apply(line)
    out.append(result)
  }
}



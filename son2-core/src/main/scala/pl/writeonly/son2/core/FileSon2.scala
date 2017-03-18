package pl.writeonly.son2.core

import java.io._
import java.net.URI

import scala.io.Source
import pl.writeonly.son2.util.Control._

object FileSon2 {
  val UTF_8  = "UTF-8"
}

abstract class FileSon2(val onml: Son2) {

  def convertFile(in: String, out: String): Unit = convertFile(new File(in), new File(out))

  def convertFile(in: URI, out: URI): Unit

  def convertFile(in: File, out: File): Unit

  def convertString(in : String) : String = {
    Option(in).map { s =>
      val bytes = convertBytes(in.getBytes(FileSon2.UTF_8))
      new String(bytes, FileSon2.UTF_8)
    }.orNull
  }

  def convertStringNative(in : String ) : String

  def convertBytes(in : Array[Byte]): Array[Byte]

  def convertStream(in: InputStream, out: OutputStream): Unit

  protected def appendLine(out: Writer, line: String): Unit = {
    val yaml = onml.applyTry(line)
    out.append(yaml)
  }
  protected def appendLine(out: StringBuilder, line: String): Unit = {
    val yaml = onml.applyTry(line)
    out.append(yaml)
  }
}

class FileSon2Impl(onml: Son2) extends FileSon2(onml) {

  override def convertFile(in: URI, out: URI): Unit = convertFile(new File(in), new File(out))

  override def convertFile(in: File, out: File): Unit = convertStream(new FileInputStream(in), new FileOutputStream(out))

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    convertNative(new InputStreamReader(in, FileSon2.UTF_8), new OutputStreamWriter(out, FileSon2.UTF_8))
  }

  override def convertStringNative(in : String): String = {
    val out = new StringWriter()
    convertNative(new StringReader(in), out)
    out.toString
  }

  override def convertBytes(in : Array[Byte]): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    convertStream(new ByteArrayInputStream(in), out)
    out.toByteArray
  }

  def convertNative(in: Reader, out: Writer): Unit = {
    using(new BufferedWriter(out)) { bw =>
      using(new BufferedReader(in)) { br =>
        convertBuffered(br, bw)
      }
    }
  }

  def convertBuffered(in: BufferedReader, out: BufferedWriter): Unit = {
    in.lines().forEach { (line: String) =>
      appendLine(out, line)
    }
  }
}

class FileSon2Source(onml: Son2) extends FileSon2(onml) {

  def convertStringNative(in:String):String = {
    val sb = new StringBuilder()
    Source.fromString(in).getLines().foreach { line =>
      appendLine(sb, line)
    }
    sb.toString
  }

  override def convertBytes(in: Array[Byte]): Array[Byte] = {
      val sb = new StringBuilder()
      Source.fromRawBytes(in).getLines().foreach { line =>
        appendLine(sb, line)
      }
      sb.toString.getBytes
    }

  override def convertFile(in: URI, out: URI): Unit = {
    using(new PrintWriter(new File(out))) { pw =>
      using(Source.fromURI(in)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }

  override def convertFile(in: File, out: File): Unit = {
    using(new PrintWriter(out)) { pw =>
      using(Source.fromFile(in)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    using(new PrintWriter(out)) { pw =>
      using(Source.fromInputStream(in, FileSon2.UTF_8)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }
}
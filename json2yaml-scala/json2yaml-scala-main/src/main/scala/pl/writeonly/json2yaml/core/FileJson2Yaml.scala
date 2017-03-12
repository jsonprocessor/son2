package pl.writeonly.json2yaml.core

import java.io._
import java.net.URI

import scala.io.Source
import pl.writeonly.json2yaml.util.Control._

abstract class FileJson2Yaml(val onml: Json2Yaml) {

  val UTF_8  = "UTF-8"

  def convertFile(in: String, out: String): Unit = convertFile(new File(in), new File(out))

  def convertFile(in: URI, out: URI): Unit = convertFile(new File(in), new File(out))

  def convertFile(in: File, out: File): Unit = convertStream(new FileInputStream(in), new FileOutputStream(out))

  def convertString(in : String) : String = {
    Option(in).map { s =>
      val bytes = convertBytes(in.getBytes(UTF_8))
      new String(bytes, UTF_8)
    }.orNull
  }

  def convertStringNative(in : String ) : String

  def convertBytes(in : Array[Byte]): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    convertStream(new ByteArrayInputStream(in), out)
    out.toByteArray
  }

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

class FileJson2YamlImpl(onml: Json2Yaml) extends FileJson2Yaml(onml) {

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    convertNative(new InputStreamReader(in, UTF_8), new OutputStreamWriter(out, UTF_8))
  }

  override def convertStringNative(in : String): String = {
    val out = new StringWriter()
    convertNative(new StringReader(in), out)
    out.toString
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

class FileJson2YamlSource(onml: Json2Yaml) extends FileJson2Yaml(onml) {

  def convertStringNative(in:String):String = {
    val sb = new StringBuilder()
    Source.fromString(in).getLines().foreach { line =>
      appendLine(sb, line)
    }
    sb.toString
  }

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    using(new PrintWriter(out)) { pw =>
      using(Source.fromInputStream(in, UTF_8)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }
}
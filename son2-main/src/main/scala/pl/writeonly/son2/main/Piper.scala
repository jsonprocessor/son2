package pl.writeonly.son2.main

import java.io.{FileInputStream, InputStream, OutputStream}

import pl.writeonly.son2.jack.glue.Streamers
import pl.writeonly.son2.jack.providers.Provider

class Piper(sin: InputStream, sout: OutputStream, val provider: Provider) {

  val impl = Streamers.pipe(true, provider)
  val source = Streamers.source(true, provider)

  def convertStream() = impl.convertStream(sin, sout)

  def convertFile(in: String, out: String) = impl.convertFile(in, out)

  def convertFile(in: String) = convertStream(new FileInputStream(in))

  def convertStream(in: InputStream) = source.convertStream(in, sout)

  def convertResource(name: String) = convertStream(resourceAsStream(name))

  def resourceAsStream(name: String) = getClass().getClassLoader().getResourceAsStream(name)

}

package pl.writeonly.son2.main

import java.io.{FileInputStream, InputStream}

import pl.writeonly.son2.jack.glue.Streamers
import pl.writeonly.son2.jack.providers.Provider

class Piper(val provider: Provider) {

  val impl = Streamers.pipe(true, provider)
  val source = Streamers.source(true, provider)

  def convertStream() = impl.convertStream(System.in, System.out)

  def convertFile(in: String, out: String) = impl.convertFile(in, out)

  def convertFile(in: String) = convertStream(new FileInputStream(in))

  def convertStream(in: InputStream) = source.convertStream(in, System.out)

  def convertResource(name: String) = convertStream(resourceAsStream(name))

  def resourceAsStream(name: String) = getClass().getClassLoader().getResourceAsStream(name)

}

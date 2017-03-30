package pl.writeonly.son2.impl.main

import java.io.{FileInputStream, InputStream}

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.streamers.{StreamerImpl, StreamerSource}
import pl.writeonly.son2.impl.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.impl.core.providers.Provider
import pl.writeonly.son2.impl.core.streamers.{StreamerImpl, StreamerSource}

//import pl.writeonly.son2.core.Converter

class ConverterImpl(val liner: Liner) /*extends Converter*/{

  def this (provider: Provider) = this(new LinerOpt (provider))

  val impl = new StreamerImpl(liner)
  val source = new StreamerSource(liner)

  def convertStream() = impl.convertStream(System.in, System.out)

  def convertFile(in: String, out: String) = impl.convertFile(in, out)

  def convertFile(in: String) = convertStream(new FileInputStream(in))

  def convertResource(name:String) = convertStream(resourceAsStream(name))

  def convertStream(in: InputStream) = source.convertStream(in, System.out)

  def resourceAsStream(name:String) = getClass().getClassLoader().getResourceAsStream(name)

}

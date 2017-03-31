package pl.writeonly.son2.test.impl

import java.io.File
import java.nio.file.Paths

object Features {
  val NAME = "writeonly"
  val PREFIX = NAME + ""
  val PATH_LOG = "/" + PREFIX + ".log"
  val YAML = ".yaml"
  val SON2 = "java -jar ../son2-core-2.8.3-SNAPSHOT.jar"
  val CAT = "cat"
  val DIR = "dir"

  def outputPathname(feature: String, scenario: String, extension :String ) = DIR +"/"+ PREFIX + feature + "" + scenario + "." + extension

  def inputURI = getClass.getResource(PATH_LOG).toURI

  def inputFile = new File(Features.inputURI)

  def inputPathname = Paths.get(inputURI).toString

  def toFile(pathname:String) = new File(pathname)

  def toURI(pathname:String) = toFile(pathname).toURI

}

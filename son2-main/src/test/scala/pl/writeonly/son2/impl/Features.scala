package pl.writeonly.son2.impl

import java.io.File
import java.net.URI
import java.nio.file.Paths

object Features {
  val NAME = "writeonly.son"
  val SON2 = "java -jar ../son2-main/target/son2-main-2.8.3-SNAPSHOT.jar"
  val CAT = "cat"
  val DIR = "dir"

  def outputPathname(feature: String, scenario: String, extension: String) =
    DIR + "/" + "son2" + "." + feature + "." + scenario + "." + extension

  def outputPathname(prefix: String, feature: String, scenario: String, extension: String) =
    DIR + "/" + prefix + "." + feature + "." + scenario + "." + extension


  def inputURI: URI = inputURI(NAME)

  def inputFile = new File(inputURI(NAME))

  def inputPathname: String = inputPathname(NAME)

  def inputPathname(name: String): String = Paths.get(inputURI(name)).toString

  def inputURI(name: String): URI = getClass.getResource("/" + name).toURI

  def toURI(pathname: String) = toFile(pathname).toURI

  def toFile(pathname: String) = new File(pathname)

}

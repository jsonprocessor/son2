package pl.writeonly.son2.apis.core

import pl.writeonly.son2.apis.config.Format

trait Formats {
  val OBJECT = Format('object)
  val CSV = Format('csv)
  val XML = Format('xml)
  val PROPERTIES = Format('properties)
  val JAVA_PROPS = Format('javaprops)

  val ALL = List(OBJECT, XML, CSV, PROPERTIES, JAVA_PROPS)

}

object Formats extends Formats

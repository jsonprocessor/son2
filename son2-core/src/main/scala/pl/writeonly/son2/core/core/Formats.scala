package pl.writeonly.son2.core.core

import pl.writeonly.son2.core.config.Format

trait Formats {
  val OBJECT = Format('object)
  val CSV = Format('csv)
  val XML = Format('xml)
  val PROPERTIES = Format('properties)
  val JAVA_PROPS = Format('javaprops)

  val ALL = List(OBJECT, XML, CSV, PROPERTIES, JAVA_PROPS)

}

object Formats extends Formats

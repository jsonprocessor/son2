package pl.writeony.scallions.scallop

import org.rogach.scallop._

object FancyThings {

  object Conf
      extends ScallopConf(
        List(
          "-Ekey1=value1",
          "key2=value2",
          "key3=value3",
          "first",
          "1",
          "2",
          "3",
          "second",
          "4",
          "5",
          "6"
        )
      ) {
    //    val props = props[String]('E')
    val firstListName = trailArg[String]()
    val firstList = trailArg[List[Int]]()
    val secondListName = trailArg[String]()
    val secondList = trailArg[List[Double]]()
    verify()
  }

}

package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath}
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderPath(val path: String) extends NotationReader {

  def readTree(content: String) = JsonPath.using(conf).parse(content).read(path)

  def conf = Configuration.defaultConfiguration()

}

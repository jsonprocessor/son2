package pl.writeonly.scallions.funs.glue

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.scallions.apis.converters.Converter

class Core(params: Params, args: Array[String], creator: CreatorConverterOr) {
  val length = args.length

  def apply: Unit = option match {
    case Good(provider) =>
      new Piper(params, provider).right(args.slice(1, length))
    case Bad(format) => bad(params, format)
  }

  def option: Converter Or ErrorMessage = length match {
    case 0 => Bad("")
    case _ => creator.converterOr(args(0).toLowerCase)
  }

  def bad(params: Params, errorMessage: ErrorMessage): Unit =
    require(requirement = false, errorMessage.asInstanceOf[Any])

}

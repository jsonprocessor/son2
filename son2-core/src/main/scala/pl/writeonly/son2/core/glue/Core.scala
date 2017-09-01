package pl.writeonly.son2.core.glue

import com.google.common.base.Preconditions
import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.core.converters.Converter

class Core(params: Params, args: Array[String], creator: CreatorConverterOr) {
  val length = args.length

  def apply = option match {
    case Good(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Bad(format) => bad(params, format)
  }

  def option: Converter Or ErrorMessage = length match {
    case 0 => Bad(null)
    case _ => creator.converterOr(args(0).toLowerCase)
  }

  def bad(params: Params, errorMessage: ErrorMessage): Unit = Preconditions.checkState(false, errorMessage.asInstanceOf[Any])

}

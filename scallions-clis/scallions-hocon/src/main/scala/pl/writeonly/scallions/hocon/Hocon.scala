package pl.writeonly.scallions.hocon

import pl.writeonly.scallions.main.{AppLazyLogging, Mainer}
import pl.writeonly.scallions.funs.glue.Params
import pl.writeonly.scallions.main.Mainer

object Hocon extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrHocon).apply
}

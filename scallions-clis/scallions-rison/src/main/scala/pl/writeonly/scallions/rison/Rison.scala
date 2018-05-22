package pl.writeonly.scallions.rison

import pl.writeonly.scallions.funs.glue.Params
import pl.writeonly.scallions.main.{AppLazyLogging, Mainer}

object Rison extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrRison).apply
}

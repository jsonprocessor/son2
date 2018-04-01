package pl.writeonly.son2.rison

import pl.writeonly.son2.funs.glue.Params
import pl.writeonly.son2.main.{AppLazyLogging, Mainer}

object Main extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrRison).apply
}

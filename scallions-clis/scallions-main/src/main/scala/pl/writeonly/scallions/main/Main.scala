package pl.writeonly.scallions.main

import pl.writeonly.scallions.funs.glue.Params

object Main extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrMain()).apply
}

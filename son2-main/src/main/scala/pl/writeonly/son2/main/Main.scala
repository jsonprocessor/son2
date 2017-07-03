package pl.writeonly.son2.main

object Main extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args).either
}


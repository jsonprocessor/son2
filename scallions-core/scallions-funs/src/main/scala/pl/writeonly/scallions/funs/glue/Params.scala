package pl.writeonly.scallions.funs.glue

import java.io.{InputStream, OutputStream}

final case class Params(in: InputStream, out: OutputStream)

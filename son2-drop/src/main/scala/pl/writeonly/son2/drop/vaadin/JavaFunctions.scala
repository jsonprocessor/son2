package pl.writeonly.son2.drop.vaadin

import java.util.function.{Function => jFunction}
object JavaFunctions {
  //  implicit def toJavaFunction[U, V](f:Function1[U,V]): Function[U, V] = new jFunction[U, V] {
  //    override def apply(t: U): V = f(t)
  //
  //    override def compose[T](before:Function[_ >: T, _ <: U]): jFunction[T, V] = toJavaFunction(f.compose(x => before.apply(x)))
  //
  //    override def andThen[W](after:Function[_ >: V, _ <: W]): jFunction[U, W] = toJavaFunction(f.andThen(x => after.apply(x)))
  //  }


  implicit def scalaFunctionToJavaFunction[From, To](function: (From) => To): java.util.function.Function[From, To] = {
    new java.util.function.Function[From, To] {
      override def apply(input: From): To = function(input)
    }
  }
}

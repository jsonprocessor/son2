package pl.writeonly.son2.vaadin.util

object JavaFunctions {

  implicit def scalaFunctionToJavaFunction[From, To](function: (From) => To): java.util.function.Function[From, To] = {
    new java.util.function.Function[From, To] {
      override def apply(input: From): To = function(input)
    }
  }
}

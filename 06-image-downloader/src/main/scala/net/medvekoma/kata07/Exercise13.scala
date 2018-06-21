package net.medvekoma.kata07

object Exercise13 extends App {

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val output = encode(input)
  println(output)

  def encode(input: List[Symbol]) : List[(Int, Symbol)] = {
    input match {
      case Nil => Nil
      case head :: _ => {
        val (block, rest) = input.span(_ == head)
        (block.size, head) :: encode(rest)
      }
    }
  }

}

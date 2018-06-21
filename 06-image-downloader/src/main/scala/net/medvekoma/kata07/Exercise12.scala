package net.medvekoma.kata07

import scala.collection.GenTraversableOnce

object Exercise12 extends App {

  val input = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

  def decode(input: List[(Int, Symbol)]) : List[Symbol] = input
//    .flatMap(pair => List.fill(pair._1)(pair._2))
    .flatMap2 { (count, symbol) => List.fill(count)(symbol) }
//    .flatMap { case (count, symbol) => List.fill(count)(symbol) }

  val output = decode(input)
  println(output)

  implicit class PairList[T1, T2](list: List[(T1, T2)]) {
    def flatMap2[T](f: (T1, T2) => GenTraversableOnce[T]): List[T] =
      list.flatMap{ case (t1, t2) => f(t1, t2)}
  }
}

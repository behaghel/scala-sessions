package session2

sealed trait List[+A] {
  def head: A
  def tail: List[A]
  def isEmpty: Boolean
  // covariance requires us to define B in the following signature but
  // think of it as an A
  def setHead[B >: A](a: B): List[B] = ???
  def drop(n: Int): List[A] = ???
  def dropWhile(p: A => Boolean): List[A] = ???
  def append[B >: A](that: List[B]): List[B] = ???
  // return all but last element
  def init: List[A] = ???
}
case object Nil extends List[Nothing] {
  override def tail = sys.error("Empty list")
  override def head = sys.error("Empty list")
  override def isEmpty = true
}
case class Cons[+A](head: A, tail: List[A]) extends List[A] {
  override def isEmpty = false
}

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil else Cons(as.head, apply(as.tail: _*))

  def sum(ints: List[Int]): Int = ???
  def product(ds: List[Double]): Double = ???
}

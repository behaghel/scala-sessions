package session0

import annotation.tailrec

object Euler3 {
  def largestPrimeFactor(n: BigInt)(primes: Int => Seq[Int]): Option[Int] = {
    // val upperBound = BigInt(math.sqrt(n.toDouble).round.toString)
    val upperBound = math.sqrt(n.toDouble).round.toInt
    val primeFactorsInterval = primes(upperBound)
    primeFactorsInterval.reverse.find(n % _ == 0)
  }
  def solveWith(primes: Int => Seq[Int]) =
    largestPrimeFactor(BigInt("600851475143"))(primes)
}

object Hubert {
  val primeNumbers = Stream.iterate(BigInt(2))(_.bigInteger.nextProbablePrime())
  def primes(upperBound: Int): Seq[Int] =
    primeNumbers.takeWhile(_ < upperBound).map(_.toInt).toList
}

object Eratosthenes {

  def primesImperative(upTo: Int): Seq[Int] = {
    // mutable is already a smell in FP
    import collection.mutable.ListBuffer
    val primeCandidates = ListBuffer.range(2, upTo+1)
    val primeNumbers = ListBuffer.empty[Int]

    def eliminate(divisor: Int): Unit =
      for (i <- primeCandidates if i % divisor == 0)
        primeCandidates -= i // mutation!

    while (primeCandidates.nonEmpty) {
      val n = primeCandidates.head
      primeNumbers += n // mutation!
      eliminate(n)
    }

    primeNumbers
  }

  // map-reduce style
  def primesMRS(n: Int): Seq[Int] = {
    val candidates = Set.empty ++ (2 to n)
    val mapped = for { i <- candidates }
                 yield candidates filterNot { x => x % i == 0 && i != x }
    mapped reduce { _ intersect _ } toSeq// not divisible but by 1 and itself
  }

  // state-passing style
  def primesSPS(n: Int): List[Int] = {
    @tailrec
    def go(acc: List[Int], candidates: List[Int]): List[Int] =
      candidates match {
        case Nil => acc
        case x :: xs => go(x :: acc, xs filterNot { _ % x == 0 })
      }
    go(Nil, (2 to n).toList) reverse
  }
}

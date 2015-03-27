package session0

import org.scalameter.api._

object PrimeNumbersBenchmark extends PerformanceTest.Quickbenchmark {

  import session1._

  val upperBounds = Gen.range("upperBound")(30, 1000, 75)
  performance of "eratosthene sieve" in {
    measure method "primesImperative" in {
      using(upperBounds) in {
        max => Eratosthenes.primesImperative(max)
      }
    }
    measure method "primesMRS" in {
      using(upperBounds) in {
        max => Eratosthenes.primesMRS(max)
      }
    }
    measure method "primesSPS" in {
      using(upperBounds) in {
        max => Eratosthenes.primesSPS(max)
      }
    }
  }

  val unit = Gen.unit("")
  val boundary = BigInt(100000)
  performance of "solving problem #3 of Project Euler" in {
    measure method "Hubert's solution (100000)" in {
      using(unit) in {
        _ => Euler3.largestPrimeFactor(boundary)(Hubert.primes _)
      }
    }
    measure method "Eratosthenes Imperative (100000)" in {
      using(unit) in {
        _ => Euler3.largestPrimeFactor(boundary)(Eratosthenes.primesImperative _)
      }
    }
    measure method "Eratosthenes Map Reduce Style (100000)" in {
      using(unit) in {
        _ => Euler3.largestPrimeFactor(boundary)(Eratosthenes.primesMRS _)
      }
    }
    measure method "Eratosthenes State Passing Style (100000)" in {
      using(unit) in {
        _ => Euler3.largestPrimeFactor(boundary)(Eratosthenes.primesSPS _)
      }
    }
    measure method "Hubert's solution (for real: 600851475143)" in {
      using(unit) in {
        _ => Euler3.solveWith(Hubert.primes _)
      }
    }
  }

}
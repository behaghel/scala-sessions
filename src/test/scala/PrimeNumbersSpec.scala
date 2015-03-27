package session0

import sessions.UnitSpec
import org.scalacheck._

class PrimeNumbersSpec extends UnitSpec {

  "various impl" should "produce the same result" in {
    import Eratosthenes._

    val upperBounds = Gen.choose(2, 300)
    forAll(upperBounds) { (n: Int) =>
      whenever (n > 2 && n <= 300) {
        val imperative = primesImperative(n).toList.sorted
        val mrs = primesMRS(n).toList.sorted
        val sps = primesSPS(n).toList.sorted
        imperative should equal (mrs)
        imperative should equal (sps)
      }
    }
  }
}
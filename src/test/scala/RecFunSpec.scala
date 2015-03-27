package session1

import sessions.UnitSpec
import org.scalacheck._

class RecFunSpec extends UnitSpec {

  import RecFun._

  "pascal" should "compute Pascal's triangle numbers" in {
    pending
    assert(pascal(0,2) === 1)
    assert(pascal(1,2) === 2)
    assert(pascal(1,3) === 3)
  }

  "balance" should "detect balanced expressions" in {
    pending
    def testBalance(s: String, expected: Boolean = true) =
      assert(if (expected) balance(s.toList) else !balance(s.toList),
             "%s should %s be balanced".format(s,
                                               if (!expected) "NOT" else ""))
    testBalance("(if (zero? x) max (/ 1 x))")
    testBalance("I told him (that it's not (yet) done)." +
                  "(But he wasn’t listening)")
    testBalance(":-)", expected = false)
    testBalance("())(", expected = false)
  }

  "countChange" should "count how many different ways you can make change" in {
    pending
  }
}
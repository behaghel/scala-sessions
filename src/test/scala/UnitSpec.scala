package sessions

import org.scalatest._
import org.scalactic.TypeCheckedTripleEquals

class UnitSpec extends FlatSpec
    with Matchers
    with TypeCheckedTripleEquals
    with prop.PropertyChecks
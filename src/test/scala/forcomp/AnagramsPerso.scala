package forcomp

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by Jean-Baptiste on 30/04/2017.
  */
@RunWith(classOf[JUnitRunner])
class AnagramsUtilsSuite extends FunSuite {

  test("prochain") {
    val ar1 = Array(true, false, true, true, true)
    val ar2 = Array(false, false, true, true, true)
    assert(AnagramsUtils.prochain(ar1) === Array(false, true, true, true, true))
//    assert(AnagramsUtils.prochain(ar2) === ar2)
  }

  test("sousCombinaison") {
    val l2 = List(('a', 2), ('b', 3),('c', 2))
    val str1 = l2.foldLeft[String]("")( (z, p) => z.concat(p._1.toString*p._2) )
    val result = AnagramsUtils.sousCombinaison(str1, 3)
    val l3 = result.toSet.toList
    println ("taille => " + l3.length)
    assert( l3 === List("aab", "aab") )
  }

}



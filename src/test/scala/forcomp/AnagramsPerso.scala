package forcomp

import forcomp.Anagrams._
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
    assert(AnagramsUtils.prochain(ar2) === ar2)
  }

  test("sousCombinaison 3 ") {
    val l2 = List(('a', 2), ('b', 3),('c', 2))
    val str1 = l2.foldLeft[String]("")( (z, p) => z.concat(p._1.toString*p._2) )
    val result = AnagramsUtils.sousCombinaison(str1, 3)
    assert( AnagramsUtils.sousCombinaison(str1, 1).toSet === List("a" , "b", "c").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 2).toSet === List("aa", "ab", "ac", "bb", "bc", "cc").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 3).toSet === List("aab", "aac", "abb", "abc", "acc", "bbb", "bbc", "bcc").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 4).toSet === List("aabb" , "aabc", "aacc", "abbc", "abcc", "bbbc", "bbcc", "abbb").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 5).toSet === List("aabbb", "aabbc", "aabcc", "abbbc", "abbcc", "bbbcc").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 6).toSet === List("aabbbc", "aabbcc", "abbbcc").toSet )
    assert( AnagramsUtils.sousCombinaison(str1, 7).toSet === List("aabbbcc").toSet )
  }

  test("sousCombinaison aabb") {
    val abba = List(('a', 2), ('b', 2))
//    val res = AnagramsUtils.sousCombinaison("aabb", 1)

    val l1 = combinations(abba)

    val l2 = l1 :: List()

    println (l2)
  }


//  test("aze") {
//    val l2 = List(List(('a', 2), ('b', 3)), List(('c', 2)))
//    val l1 = List(List(('a', 3), ('b', 2)), List(('d', 1)))
//    val l3 = List(List(('a', 1), ('b', 1)), List(('d', 3)))
//
//    val t = Array(l1, l2, l3)
//    val l4 = t.reduceLeft[List[Occurrences]]((z,b) => z ++ b)
//    println (l4)
//  }


}



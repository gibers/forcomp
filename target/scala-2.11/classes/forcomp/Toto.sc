//package forcomp;
import forcomp.Anagrams._
import forcomp.AnagramsUtils._
object Toto {
  val l1 = List("un","de", "deux", "trois", "quatre")
  val l2 = List(('a', 2), ('b', 3),('c', 2))
  l1.groupBy[Int](ele => ele.length)
  l1.fold[String]("")( (a,b) => a.concat(b) )
  val str1 = l2.foldLeft[String]("")( (z, p) => z.concat(p._1.toString*p._2) )

  def element(chaine:String, tab:Array[Boolean]): Word = {
    val l1 = for(ele <- tab.indices if tab(ele))
      yield chaine(ele)
    l1.mkString
  }

  def sousCombinaison(chaine:String, nb:Int): List[String] = {
    var l1 = List[String]()
    val tab = new Array[Boolean](chaine.length)
    var tab1 = tab.take(nb).map(_ => true) union tab.drop(nb)
    val premierMot = element(chaine, tab1)
    l1 = premierMot :: l1
    var proTab = prochain(tab1)
    println (proTab.toList)
    println ("diff => " + proTab != tab1)
    var compt = 0
    while(proTab != tab1) {
      compt += 1
      tab1 = proTab
      l1 = element(chaine, tab1) :: l1
      proTab = prochain(tab1)
    }
    println ("compt => " + compt)
    l1
  }

  def affiche(tab: Array[Boolean]): Unit = {
    val res = for(ele <- tab) yield ele
    println (res)
  }
}
val ar = Array[Boolean](true, false, true, true, true)
ar.foldLeft[Int](0)( (z,a) => if(a) z + 1 else z )
val ard = new Array[Boolean](6)
ard.take(2).map(_ => true) union ard.drop(2)
Toto.str1
Toto.sousCombinaison(Toto.str1, 3)
Toto.element(Toto.str1, ar)
val l0 = List
var l1 = List("a" , "b", "c")
val l2 = List("aa", "ab", "ac", "bb", "bc", "cc")
val l3 = List("xxx", "xx")
val l = l1 ++ l2
val tab = Array("toto", "titi", "tutu")
tab.foldLeft[String]("")((z,b) => z.concat(b))
tab.reduceLeft[String]((z,b) => z.concat(b))




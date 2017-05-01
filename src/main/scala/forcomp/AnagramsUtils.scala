package forcomp

import forcomp.Anagrams._

/**
  * Created by Jean-Baptiste on 30/04/2017.
  */
object AnagramsUtils {

  def dernierTrue(tabl:Array[Boolean], indice: Int): Int = {
    val nt = tabl.drop(indice)
    val nbTrue = nt.foldLeft[Int](0)( (z,a) => if(a) z + 1 else z )
    nbTrue
  }

  def prochain(tab: Array[Boolean]): Array[Boolean] = {
    val nbUn = tab.filter(a=>a).length
    if(!tab.takeRight(nbUn).contains(false))
    return tab
    def getFalseTrue(): Int = {
      for(ele <- 0 until tab.length -1)
      if(!tab.reverse(ele) && tab.reverse(ele+1))
      return ele.toInt
      return -1
    }
    val indice = getFalseTrue()
    val seuil = tab.length - indice -1
    val nbTrue = dernierTrue(tab, seuil)
    val newTab = tab.clone()
    newTab(seuil) = true
    newTab(seuil -1) = false
    for(ele <- 1 to nbTrue) newTab(seuil + ele) = true
    for(ele <- seuil +1 +nbTrue until newTab.length) newTab(ele) = false
    newTab
  }

  def sousCombinaison(chaine:Word, nb:Int): List[Word] = {
    var l1 = List[String]()
    val tab = new Array[Boolean](chaine.length)
    var tab1 = tab.take(nb).map(_ => true) union tab.drop(nb)
    val premierMot = element(chaine, tab1)
    l1 = premierMot :: l1
    var proTab = prochain(tab1)
    while(proTab != tab1) {
      tab1 = proTab
      l1 = element(chaine, tab1) :: l1
      proTab = prochain(tab1)
    }
    l1.toSet.toList
  }

  def element(chaine:String, tab:Array[Boolean]): Word = {
    val l1 = for(ele <- tab.indices if tab(ele))
      yield chaine(ele)
    l1.mkString
  }

}

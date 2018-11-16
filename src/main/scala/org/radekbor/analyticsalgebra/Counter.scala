package org.radekbor.analyticsalgebra

protected object Rotator {
  def shift(in: String, x: Int): String = {
    val n = x % in.length
    in.substring(n, in.length) + in.substring(0, n)
  }
}


class Counter(val k: Int, val n: Int) {

  private val data = Array.ofDim[Int](k, n)

  def add(item: String): Unit = {

    val hashes = calcHashes(item)
    hashes.zipWithIndex.foreach(
      pair => {
        val index = pair._2
        val hash = pair._1
        data(hash)(index) += 1
      }
    )

  }

  def count(item: String)=  {

    val hashes = calcHashes(item)
    hashes.zipWithIndex.map(pair => {
      val index = pair._2
      val hash = pair._1
      data(hash)(index)
    }).min
  }

  private def calcHashes(item: String): Seq[Int] = {
    Range(0, n)
      .map(p => Rotator.shift(item, p))
      .map(str => str.hashCode % k)
  }

}

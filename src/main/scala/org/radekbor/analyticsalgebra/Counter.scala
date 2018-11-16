package org.radekbor.analyticsalgebra


class Counter(val k: Int, val n: Int) {

  private val data = Array.ofDim[Int](k, n)

  private val hashesGenerator = new HashesGenerator(k, n)

  def add(item: String): Unit = {

    val hashes = hashesGenerator.calcHashes(item)
    hashes.zipWithIndex.foreach(
      pair => {
        val index = pair._2
        val hash = pair._1
        data(hash)(index) += 1
      }
    )

  }

  def count(item: String): Int = {

    val hashes = hashesGenerator.calcHashes(item)
    hashes.zipWithIndex.map(pair => {
      val index = pair._2
      val hash = pair._1
      data(hash)(index)
    }).min
  }


}

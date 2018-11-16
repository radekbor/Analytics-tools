package org.radekbor.analyticsalgebra

class BloomFilter(val k: Int, val n: Int) {

  private val hashesGenerator = new HashesGenerator(k, n)

  private val data = Array.ofDim[Boolean](k)

  def add(item: String): Unit = {
    val hashes = hashesGenerator.calcHashes(item)
    hashes.foreach(hash =>
      data(hash) = true
    )
  }

  def isIn(item: String): Boolean = {
    val hashes = hashesGenerator.calcHashes(item)
    hashes.forall(hash => data(hash))
  }

}

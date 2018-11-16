package org.radekbor.analyticsalgebra

object BloomFilterExample {

  def main(stream: Array[String]) = {

    val bloomFilter = new BloomFilter(23, 5)

    val JOHN = "John"
    val DAVE = "Dave"
    val CRIS = "Cris"
    val TOM = "Tom"

    bloomFilter.add(JOHN)
    bloomFilter.add(DAVE)
    bloomFilter.add(CRIS)

    println(s"bloomFilter.isIn($JOHN) = ${bloomFilter.isIn(JOHN)}")
    println(s"bloomFilter.isIn($CRIS) = ${bloomFilter.isIn(CRIS)}")
    println(s"bloomFilter.isIn($DAVE) = ${bloomFilter.isIn(DAVE)}")
    println(s"bloomFilter.isIn($TOM) = ${bloomFilter.isIn(TOM)}")
  }
}

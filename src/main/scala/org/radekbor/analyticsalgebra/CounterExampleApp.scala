package org.radekbor.analyticsalgebra


class CounterExampleApp {

  def main(args: Array[String]): Unit = {

    val counter = new Counter(23, 5)


    for (i <- Range(0, 10)) {
      counter.add("John")
    }
    for (i <- Range(0, 3)) {
      counter.add("Dave")
    }
    for (i <- Range(0, 4)) {
      counter.add("Cris")
    }

    println(counter.count("John"))
    println(counter.count("Dave"))
    println(counter.count("Cris"))

  }

}
